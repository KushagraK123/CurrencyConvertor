package com.empyrealgames.currencyconvertor


import android.content.Intent
import android.os.AsyncTask
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
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {

    val rate = Global.Rates

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DownloadData().execute("http://data.fixer.io/api/latest?access_key=778a18d9d45590dfd908cf4338c0ddb3")

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return true
    }


    inner class DownloadData: AsyncTask<String, Void , String>(){
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                val jsonObject = JSONObject(result!!)
                val rates = JSONObject(jsonObject.get("rates").toString())
                rate.rate = rates


                 rate.countryCodes = JSONObject("{\n" +
                        "  \"AED\": \"United Arab Emirates Dirham\",\n" +
                        "  \"AFN\": \"Afghan Afghani\",\n" +
                        "  \"ALL\": \"Albanian Lek\",\n" +
                        "  \"AMD\": \"Armenian Dram\",\n" +
                        "  \"ANG\": \"Netherlands Antillean Guilder\",\n" +
                        "  \"AOA\": \"Angolan Kwanza\",\n" +
                        "  \"ARS\": \"Argentine Peso\",\n" +
                        "  \"AUD\": \"Australian Dollar\",\n" +
                        "  \"AWG\": \"Aruban Florin\",\n" +
                        "  \"AZN\": \"Azerbaijani Manat\",\n" +
                        "  \"BAM\": \"Bosnia-Herzegovina Convertible Mark\",\n" +
                        "  \"BBD\": \"Barbadian Dollar\",\n" +
                        "  \"BDT\": \"Bangladeshi Taka\",\n" +
                        "  \"BGN\": \"Bulgarian Lev\",\n" +
                        "  \"BHD\": \"Bahraini Dinar\",\n" +
                        "  \"BIF\": \"Burundian Franc\",\n" +
                        "  \"BMD\": \"Bermudan Dollar\",\n" +
                        "  \"BND\": \"Brunei Dollar\",\n" +
                        "  \"BOB\": \"Bolivian Boliviano\",\n" +
                        "  \"BRL\": \"Brazilian Real\",\n" +
                        "  \"BSD\": \"Bahamian Dollar\",\n" +
                        "  \"BTC\": \"Bitcoin\",\n" +
                        "  \"BTN\": \"Bhutanese Ngultrum\",\n" +
                        "  \"BWP\": \"Botswanan Pula\",\n" +
                        "  \"BYN\": \"Belarusian Ruble\",\n" +
                        "  \"BZD\": \"Belize Dollar\",\n" +
                        "  \"CAD\": \"Canadian Dollar\",\n" +
                        "  \"CDF\": \"Congolese Franc\",\n" +
                        "  \"CHF\": \"Swiss Franc\",\n" +
                        "  \"CLF\": \"Chilean Unit of Account (UF)\",\n" +
                        "  \"CLP\": \"Chilean Peso\",\n" +
                        "  \"CNH\": \"Chinese Yuan (Offshore)\",\n" +
                        "  \"CNY\": \"Chinese Yuan\",\n" +
                        "  \"COP\": \"Colombian Peso\",\n" +
                        "  \"CRC\": \"Costa Rican Colón\",\n" +
                        "  \"CUC\": \"Cuban Convertible Peso\",\n" +
                        "  \"CUP\": \"Cuban Peso\",\n" +
                        "  \"CVE\": \"Cape Verdean Escudo\",\n" +
                        "  \"CZK\": \"Czech Republic Koruna\",\n" +
                        "  \"DJF\": \"Djiboutian Franc\",\n" +
                        "  \"DKK\": \"Danish Krone\",\n" +
                        "  \"DOP\": \"Dominican Peso\",\n" +
                        "  \"DZD\": \"Algerian Dinar\",\n" +
                        "  \"EGP\": \"Egyptian Pound\",\n" +
                        "  \"ERN\": \"Eritrean Nakfa\",\n" +
                        "  \"ETB\": \"Ethiopian Birr\",\n" +
                        "  \"EUR\": \"Euro\",\n" +
                        "  \"FJD\": \"Fijian Dollar\",\n" +
                        "  \"FKP\": \"Falkland Islands Pound\",\n" +
                        "  \"GBP\": \"British Pound Sterling\",\n" +
                        "  \"GEL\": \"Georgian Lari\",\n" +
                        "  \"GGP\": \"Guernsey Pound\",\n" +
                        "  \"GHS\": \"Ghanaian Cedi\",\n" +
                        "  \"GIP\": \"Gibraltar Pound\",\n" +
                        "  \"GMD\": \"Gambian Dalasi\",\n" +
                        "  \"GNF\": \"Guinean Franc\",\n" +
                        "  \"GTQ\": \"Guatemalan Quetzal\",\n" +
                        "  \"GYD\": \"Guyanaese Dollar\",\n" +
                        "  \"HKD\": \"Hong Kong Dollar\",\n" +
                        "  \"HNL\": \"Honduran Lempira\",\n" +
                        "  \"HRK\": \"Croatian Kuna\",\n" +
                        "  \"HTG\": \"Haitian Gourde\",\n" +
                        "  \"HUF\": \"Hungarian Forint\",\n" +
                        "  \"IDR\": \"Indonesian Rupiah\",\n" +
                        "  \"ILS\": \"Israeli New Sheqel\",\n" +
                        "  \"IMP\": \"Manx pound\",\n" +
                        "  \"INR\": \"Indian Rupee\",\n" +
                        "  \"IQD\": \"Iraqi Dinar\",\n" +
                        "  \"IRR\": \"Iranian Rial\",\n" +
                        "  \"ISK\": \"Icelandic Króna\",\n" +
                        "  \"JEP\": \"Jersey Pound\",\n" +
                        "  \"JMD\": \"Jamaican Dollar\",\n" +
                        "  \"JOD\": \"Jordanian Dinar\",\n" +
                        "  \"JPY\": \"Japanese Yen\",\n" +
                        "  \"KES\": \"Kenyan Shilling\",\n" +
                        "  \"KGS\": \"Kyrgystani Som\",\n" +
                        "  \"KHR\": \"Cambodian Riel\",\n" +
                        "  \"KMF\": \"Comorian Franc\",\n" +
                        "  \"KPW\": \"North Korean Won\",\n" +
                        "  \"KRW\": \"South Korean Won\",\n" +
                        "  \"KWD\": \"Kuwaiti Dinar\",\n" +
                        "  \"KYD\": \"Cayman Islands Dollar\",\n" +
                        "  \"KZT\": \"Kazakhstani Tenge\",\n" +
                        "  \"LAK\": \"Laotian Kip\",\n" +
                        "  \"LBP\": \"Lebanese Pound\",\n" +
                        "  \"LKR\": \"Sri Lankan Rupee\",\n" +
                        "  \"LRD\": \"Liberian Dollar\",\n" +
                        "  \"LSL\": \"Lesotho Loti\",\n" +
                        "  \"LYD\": \"Libyan Dinar\",\n" +
                        "  \"MAD\": \"Moroccan Dirham\",\n" +
                        "  \"MDL\": \"Moldovan Leu\",\n" +
                        "  \"MGA\": \"Malagasy Ariary\",\n" +
                        "  \"MKD\": \"Macedonian Denar\",\n" +
                        "  \"MMK\": \"Myanma Kyat\",\n" +
                        "  \"MNT\": \"Mongolian Tugrik\",\n" +
                        "  \"MOP\": \"Macanese Pataca\",\n" +
                        "  \"MRO\": \"Mauritanian Ouguiya (pre-2018)\",\n" +
                        "  \"MRU\": \"Mauritanian Ouguiya\",\n" +
                        "  \"MUR\": \"Mauritian Rupee\",\n" +
                        "  \"MVR\": \"Maldivian Rufiyaa\",\n" +
                        "  \"MWK\": \"Malawian Kwacha\",\n" +
                        "  \"MXN\": \"Mexican Peso\",\n" +
                        "  \"MYR\": \"Malaysian Ringgit\",\n" +
                        "  \"MZN\": \"Mozambican Metical\",\n" +
                        "  \"NAD\": \"Namibian Dollar\",\n" +
                        "  \"NGN\": \"Nigerian Naira\",\n" +
                        "  \"NIO\": \"Nicaraguan Córdoba\",\n" +
                        "  \"NOK\": \"Norwegian Krone\",\n" +
                        "  \"NPR\": \"Nepalese Rupee\",\n" +
                        "  \"NZD\": \"New Zealand Dollar\",\n" +
                        "  \"OMR\": \"Omani Rial\",\n" +
                        "  \"PAB\": \"Panamanian Balboa\",\n" +
                        "  \"PEN\": \"Peruvian Nuevo Sol\",\n" +
                        "  \"PGK\": \"Papua New Guinean Kina\",\n" +
                        "  \"PHP\": \"Philippine Peso\",\n" +
                        "  \"PKR\": \"Pakistani Rupee\",\n" +
                        "  \"PLN\": \"Polish Zloty\",\n" +
                        "  \"PYG\": \"Paraguayan Guarani\",\n" +
                        "  \"QAR\": \"Qatari Rial\",\n" +
                        "  \"RON\": \"Romanian Leu\",\n" +
                        "  \"RSD\": \"Serbian Dinar\",\n" +
                        "  \"RUB\": \"Russian Ruble\",\n" +
                        "  \"RWF\": \"Rwandan Franc\",\n" +
                        "  \"SAR\": \"Saudi Riyal\",\n" +
                        "  \"SBD\": \"Solomon Islands Dollar\",\n" +
                        "  \"SCR\": \"Seychellois Rupee\",\n" +
                        "  \"SDG\": \"Sudanese Pound\",\n" +
                        "  \"SEK\": \"Swedish Krona\",\n" +
                        "  \"SGD\": \"Singapore Dollar\",\n" +
                        "  \"SHP\": \"Saint Helena Pound\",\n" +
                        "  \"SLL\": \"Sierra Leonean Leone\",\n" +
                        "  \"SOS\": \"Somali Shilling\",\n" +
                        "  \"SRD\": \"Surinamese Dollar\",\n" +
                        "  \"SSP\": \"South Sudanese Pound\",\n" +
                        "  \"STD\": \"São Tomé and Príncipe Dobra (pre-2018)\",\n" +
                        "  \"STN\": \"São Tomé and Príncipe Dobra\",\n" +
                        "  \"SVC\": \"Salvadoran Colón\",\n" +
                        "  \"SYP\": \"Syrian Pound\",\n" +
                        "  \"SZL\": \"Swazi Lilangeni\",\n" +
                        "  \"THB\": \"Thai Baht\",\n" +
                        "  \"TJS\": \"Tajikistani Somoni\",\n" +
                        "  \"TMT\": \"Turkmenistani Manat\",\n" +
                        "  \"TND\": \"Tunisian Dinar\",\n" +
                        "  \"TOP\": \"Tongan Pa'anga\",\n" +
                        "  \"TRY\": \"Turkish Lira\",\n" +
                        "  \"TTD\": \"Trinidad and Tobago Dollar\",\n" +
                        "  \"TWD\": \"New Taiwan Dollar\",\n" +
                        "  \"TZS\": \"Tanzanian Shilling\",\n" +
                        "  \"UAH\": \"Ukrainian Hryvnia\",\n" +
                        "  \"UGX\": \"Ugandan Shilling\",\n" +
                        "  \"USD\": \"United States Dollar\",\n" +
                        "  \"UYU\": \"Uruguayan Peso\",\n" +
                        "  \"UZS\": \"Uzbekistan Som\",\n" +
                        "  \"VEF\": \"Venezuelan Bolívar Fuerte (Old)\",\n" +
                        "  \"VES\": \"Venezuelan Bolívar Soberano\",\n" +
                        "  \"VND\": \"Vietnamese Dong\",\n" +
                        "  \"VUV\": \"Vanuatu Vatu\",\n" +
                        "  \"WST\": \"Samoan Tala\",\n" +
                        "  \"XAF\": \"CFA Franc BEAC\",\n" +
                        "  \"XAG\": \"Silver Ounce\",\n" +
                        "  \"XAU\": \"Gold Ounce\",\n" +
                        "  \"XCD\": \"East Caribbean Dollar\",\n" +
                        "  \"XDR\": \"Special Drawing Rights\",\n" +
                        "  \"XOF\": \"CFA Franc BCEAO\",\n" +
                        "  \"XPD\": \"Palladium Ounce\",\n" +
                        "  \"XPF\": \"CFP Franc\",\n" +
                        "  \"XPT\": \"Platinum Ounce\",\n" +
                        "  \"YER\": \"Yemeni Rial\",\n" +
                        "  \"ZAR\": \"South African Rand\",\n" +
                        "  \"ZMW\": \"Zambian Kwacha\",\n" +
                        "  \"ZWL\": \"Zimbabwean Dollar\"\n }")
                init()
                layout.removeView(progressBar)
                layout.removeView(loadingText)
                }catch (e:Exception){
                e.printStackTrace()
            }
        }



        override fun doInBackground(vararg params: String?): String {

            val result = StringBuilder("")
            val url: URL
            val httpURLConnection: HttpURLConnection
            try {

                url = URL(params[0])
                httpURLConnection = url.openConnection() as HttpURLConnection
                val inputStream = httpURLConnection.inputStream
                val inputStreamReader = InputStreamReader(inputStream)

                var data = inputStreamReader.read()
                while (data > 0){
                    result.append(data.toChar())
                    data =  inputStreamReader.read()
                }

            }catch (e: Exception){
                e.printStackTrace()
            }


            return result.toString()
        }

    }
    fun init(){
        rate.countryKeys = ArrayList()
        rate.countryValues = ArrayList()
        if(rate.rate!=null) {
            val keys = rate.rate!!.keys()
            while (keys.hasNext()){
                val x = keys.next()
                if(rate.countryCodes!!.has(x) ) {
                    rate.countryKeys!!.add(x)
                    rate.countryValues!!.add(rate.countryCodes!!.getString(x))
                }
            }

            val spinnerArrayAdapter = ArrayAdapter(
                applicationContext, android.R.layout.simple_spinner_item, rate.countryValues!!)
            spinnerArrayAdapter.setDropDownViewResource(
                android.R.layout
                    .simple_spinner_dropdown_item
            )
            counrty1Spinner.adapter = spinnerArrayAdapter
            counrty2Spinner.adapter = spinnerArrayAdapter
        }

        country1EditText.addTextChangedListener(
            object : TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    updateRates()
                }
                override fun afterTextChanged(s: Editable?) {

                }
            }
        )


        counrty1Spinner.onItemSelectedListener = Listener()
        counrty2Spinner.onItemSelectedListener = Listener()

    }

    inner class Listener : AdapterView.OnItemSelectedListener{
        override fun onNothingSelected(parent: AdapterView<*>?) {
            updateRates()
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            updateRates()
        }

    }

    fun updateRates(){
        try {
            val amount: Double = (country1EditText.text.toString()).toDouble()
            val x = rate.rate!!.getDouble(rate.countryKeys!![counrty1Spinner.selectedItemPosition])
            val y = rate.rate!!.getDouble(rate.countryKeys!![counrty2Spinner.selectedItemPosition])
            val ans = String.format("%.3f", (amount * y / x))
            country2Textview.text = ans
        }catch (e: Exception){
            e.printStackTrace()
            country2Textview.text = ""

        }
    }

/*after menu items click*/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.compareCurrencies -> {
                /*start compare activity*/
                if(rate.countryKeys == null){
                    Toast.makeText(applicationContext, "Please Connect to Internet", Toast.LENGTH_LONG).show()
                }else {
                    val intent = Intent(applicationContext, CompareActivity::class.java)
                    startActivity(intent)
                }
                true
            }
            R.id.exit -> {
                super.finishAndRemoveTask()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
