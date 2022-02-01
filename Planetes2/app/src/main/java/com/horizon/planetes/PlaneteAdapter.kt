package com.horizon.planetes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class PlaneteAdapter (
    private val context: Context,
    private val listPlanet: ArrayList<Planete>): RecyclerView.Adapter
    <PlaneteAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int){
            holder.bindView(listPlanet[position])
        }
        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            fun  bindView(data: Planete){
                itemView.findViewById<TextView>(R.id.title).text = data.nom
                itemView.findViewById<TextView>(R.id.sub_title).text= data.distance.toString()
                Picasso.get().load(data.idImage).fit().placeholder(R.mipmap.ic_launcher).into(itemView.findViewById<ImageView>(R.id.image))
                itemView.setOnClickListener {
                    val intent = Intent(context, MainActivity2::class.java).apply {
                        putExtra("name", data.nom)
                        putExtra("distance", data.distance.toString())
                        putExtra("idImage", data.idImage)
                    }
                    context.startActivity(intent)

                }
            }
        }

    override fun getItemCount(): Int {
        return listPlanet.size
    }
}

