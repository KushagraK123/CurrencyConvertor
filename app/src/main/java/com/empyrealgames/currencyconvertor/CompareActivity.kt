package com.empyrealgames.currencyconvertor

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_compare.*
import java.lang.Exception

class CompareActivity : AppCompatActivity() {

    val rate = Global.Rates
    var basePrice:Double = 0.0
    var amount:Double = 0.0
   private var arrayAdapter:CustomArrayAdapter?=null
   private var countries : ArrayList<String>? = null
   private var amounts : ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compare)




        init()

    }

    private fun init(){
        initSpinner()
        initListView()
        initEditText()
        initCalculateButton()
    }
    private fun initEditText(){
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
    private fun initSpinner(){
        val spinnerArrayAdapter = ArrayAdapter(
            applicationContext, android.R.layout.simple_spinner_item, rate.countryValues!!)
        spinnerArrayAdapter.setDropDownViewResource(
            android.R.layout
                .simple_spinner_dropdown_item
        )
        compareCurrenciesSpinner.adapter = spinnerArrayAdapter

        compareCurrenciesSpinner.onItemSelectedListener = Listener()

    }

    private fun initListView(){
        countries = ArrayList()
        amounts = ArrayList()

        for(item in rate.countryKeys!!){

            countries!!.add(rate.countryCodes!!.getString(item))
            amounts!!.add(getAmount(basePrice, rate.rate!!.getDouble(item), amount))
        }


        arrayAdapter = CustomArrayAdapter(this, countries!!, amounts!!)
        compareCurrenciesListView.adapter = arrayAdapter
        arrayAdapter!!.notifyDataSetChanged()

    }

    private fun getAmount(basePrice:Double, itemPrice:Double, amount:Double):String{

        var ans:String

        try {

            ans = String.format("%.3f",amount * itemPrice  / basePrice)

        }catch (e:Exception){
            ans = ""
        }
        return ans
    }


    inner class Listener : AdapterView.OnItemSelectedListener{
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            basePrice = rate.rate!!.getDouble(rate.countryKeys!![compareCurrenciesSpinner.selectedItemPosition])
            initListView()
        }

    }

    private  fun initCalculateButton(){
        calculate.setOnClickListener(View.OnClickListener {
            initListView()
        })
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.sort_menu,menu)
        return true
    }


    /*after menu items click*/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.sort_ascending -> {
                true
            }
            R.id.sort_descending -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
