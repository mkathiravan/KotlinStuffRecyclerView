package net.kathir.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DataAdpter(private var datalist : List<DataModel>, private val context: Context) : RecyclerView.Adapter<DataAdpter.ViewHolder>()
{

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_home, p0, false))
    }


    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        var dataModel = datalist.get(p1)
        p0.titleTextView.text = dataModel.title
    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView)
    {
        lateinit var titleTextView: TextView
        init {
            titleTextView = itemLayoutView.findViewById(R.id.title)
        }
    }
}