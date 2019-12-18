package com.empyrealgames.currencyconvertor

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_compare.*
import java.lang.Exception

class CompareActivity : AppCompatActivity() {

    val rate = Global.Rates
    var basePrice:Double = 0.0
    var amount:Double = 0.0
    var arrayAdapter:ArrayAdapter<String>?=null
    var listItem : ArrayList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compare)

        init()

    }

    fun init(){
        initSpinner()
        initListView()
    }


    fun initSpinner(){
        val spinnerArrayAdapter = ArrayAdapter(
            applicationContext, android.R.layout.simple_spinner_item, rate.countryValues!!)
        spinnerArrayAdapter.setDropDownViewResource(
            android.R.layout
                .simple_spinner_dropdown_item
        )
        compareCurrenciesSpinner.adapter = spinnerArrayAdapter

    }


    fun initListView(){
        listItem = ArrayList()
        for(item in rate.countryKeys!!){
            listItem!!.add(getListItemString(rate.countryCodes!!.getString(item), basePrice, rate.rate!!.getDouble(item), amount))
        }
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem!!)
        compareCurrenciesListView.adapter = arrayAdapter
    }

    fun getListItemString(name:String, basePrice:Double, itemPrice:Double, amount:Double):String{

        var ans = ""

        try {

            ans = (amount * itemPrice  / basePrice).toString()

        }catch (e:Exception){
            ans = ""
        }

        return String.format("%s %s", name, ans)
    }



}
