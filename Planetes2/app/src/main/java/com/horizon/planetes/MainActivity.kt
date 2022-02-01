package com.horizon.planetes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    var listOfPlanet: ArrayList<Planete> = ArrayList()
    lateinit var recyclerViewer:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         recyclerViewer= findViewById(R.id.recyclerViewer)
        addDataTo(listOfPlanet)
    }
    private fun addDataTo(listOfPlanet: ArrayList<Planete>) {
        // accès aux ressources
        val res = resources
        val noms = res.getStringArray(R.array.noms)
        val distances = res.getIntArray(R.array.distances)
        var images = arrayOf<Int>(
            R.drawable.mercure,
            R.drawable.venus,
            R.drawable.terre,
            R.drawable.mars,
            R.drawable.jupiter,
            R.drawable.saturn,
            R.drawable.uranus,
            R.drawable.neptune
            )
        //Remplir le tableau
        for (i in noms.indices) {
        listOfPlanet.add(Planete(noms[i], distances[i], images[i]))
        }
        //Affichage du contenu du tableau
        for (i in listOfPlanet.indices) {
            println("name: " +listOfPlanet[i].nom + " distance: " +listOfPlanet[i].distance)
        }

        showInView(listOfPlanet)
    }


    private fun showInView(arrayWithData: java.util.ArrayList<Planete>) {
        val adapter=PlaneteAdapter(this,listOfPlanet)
        recyclerViewer.layoutManager = LinearLayoutManager(this)
        recyclerViewer.adapter=adapter
    }
}

