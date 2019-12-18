package com.empyrealgames.currencyconvertor

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class CustomArrayAdapter(private val context: Activity, val countries: ArrayList<String>, val amounts:ArrayList<String>)
: ArrayAdapter<String>(context, R.layout.list_item) {

    internal class ViewHolder {
        var text1: TextView? = null
        var text2: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        println("here100")
        var rowView = convertView
        // reuse views
        // reuse views
        if (rowView == null) {
            val inflater = context.layoutInflater
            rowView = inflater.inflate(R.layout.list_item, parent, false)
            // configure view holder
            val viewHolder = ViewHolder()
            viewHolder.text1 = rowView!!.findViewById<View>(R.id.countryTextView) as TextView
            viewHolder.text2 = rowView
                .findViewById<View>(R.id.amountTextView) as TextView
            rowView.tag = viewHolder
        }

        val holder = rowView.tag as ViewHolder
        val country: String = countries[position]
        val amount: String = amounts[position]

        println("country " + country + " amount  " + amount)

        holder.text1!!.text = country
        holder.text2!!.text = amount

        return rowView
    }

    override fun getCount(): Int {
        return countries.size
    }


}