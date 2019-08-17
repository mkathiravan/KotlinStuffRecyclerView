package net.kathir.myapplication

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class SearchAdapter (ctx: Context, private val imageModelArrayList: ArrayList<PersonModel>) : RecyclerView.Adapter<SearchAdapter.MyViewHolder>()
{


  private val inflater: LayoutInflater
  private val arrayList: ArrayList<PersonModel>

    init {
        inflater = LayoutInflater.from(ctx)
        this.arrayList = ArrayList<PersonModel>()
        this.arrayList.addAll(RecyclerViewSearch.imageModelArrayList)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):SearchAdapter.MyViewHolder {
        val view = inflater.inflate(R.layout.rv_item,parent,false);
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: SearchAdapter.MyViewHolder, position: Int) {

        holder.person_name.setText(imageModelArrayList[position].getNames())
    }

    override fun getItemCount(): Int {
        return imageModelArrayList.size
    }




    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var person_name : TextView

        init {

            person_name = itemView.findViewById(R.id.tv) as TextView
        }
    }


    //To filter the class

    fun filter(charText: String)
    {
        var charText = charText
        charText = charText.toLowerCase(Locale.getDefault())
        RecyclerViewSearch.imageModelArrayList.clear()
        if(charText.length == 0)
        {
            RecyclerViewSearch.imageModelArrayList.addAll(arrayList)
        }
        else {
            for (wp in arrayList) {
                if (wp.getNames().toLowerCase(Locale.getDefault()).contains(charText)) {
                    RecyclerViewSearch.imageModelArrayList.add(wp)
                }
            }
        }
        notifyDataSetChanged()
    }
}