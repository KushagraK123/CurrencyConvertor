package com.empyrealgames.currencyconvertor

import org.json.JSONObject

class Global {
    companion object Rates{
        var rate: JSONObject? = null
        var countryCodes: JSONObject? = null
        var countryKeys:ArrayList<String>? = null
        var countryValues:ArrayList<String>? = null

        fun getRatesJSON():JSONObject{
            return rate!!
        }

        fun getCountryCodesJSON():JSONObject{
            return countryCodes!!
        }

        fun getCountryKeysList():ArrayList<String>{
            return countryKeys!!
        }

        fun getCountryValuesList():ArrayList<String>{
            return countryValues!!
        }

    }

}