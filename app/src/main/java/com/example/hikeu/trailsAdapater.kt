package com.example.hikeu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hikeu.databinding.ItemTrailBinding
import androidx.lifecycle.lifecycleScope



class trailsAdapater (var trails: List<OfficialTrails>) : RecyclerView.Adapter<trailsAdapater.ViewHolder>() {

    class ViewHolder(val binding: ItemTrailBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTrailBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            textViewNombreRutas.text = trails[position].name
            textViewDificultad.text = trails[position].difficulty
            textViewTiempo.text = trails[position].duration.toString() + " Minutes"
            textViewUbicacion.text = trails[position].state
            textWarnings.text = trails[position].warnings
            textClothing.text = trails[position].clothing
            textIndispensables.text = trails[position].indispensables
            textRoute.text = trails[position].googleMapsLink


        }



    }

    override fun getItemCount(): Int {
        return trails.size
    }
}



