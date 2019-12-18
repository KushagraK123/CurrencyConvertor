package com.empyrealgames.currencyconvertor

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_compare.*
import kotlinx.android.synthetic.main.activity_main.*
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
        initEditText()
    }
    fun initEditText(){
        compareCurrenciesEditText.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    try {
                         amount = (compareCurrenciesEditText.text.toString()).toDouble()
                    }catch (e: Exception){
                        e.printStackTrace()
                        amount = 0.0
                    }

                }
                override fun afterTextChanged(s: Editable?) {

                }
            }
        )

    }
    fun initSpinner(){
        val spinnerArrayAdapter = ArrayAdapter(
            applicationContext, android.R.layout.simple_spinner_item, rate.countryValues!!)
        spinnerArrayAdapter.setDropDownViewResource(
            android.R.layout
                .simple_spinner_dropdown_item
        )
        compareCurrenciesSpinner.adapter = spinnerArrayAdapter

        compareCurrenciesSpinner.onItemSelectedListener = Listener()

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
            
            ans = String.format("%.3f",amount * itemPrice  / basePrice)

        }catch (e:Exception){
            ans = ""
        }
        return String.format("%s %s", name, ans)
    }


    inner class Listener : AdapterView.OnItemSelectedListener{
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            basePrice = rate.rate!!.getDouble(rate.countryKeys!![compareCurrenciesSpinner.selectedItemPosition])
            initListView()
        }

    }


}
