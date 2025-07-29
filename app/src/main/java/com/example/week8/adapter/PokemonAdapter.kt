package com.example.week8.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.week8.R
import com.example.week8.data.Pokemon

class PokemonAdapter(
    private var pokemonList: List<Pokemon>,
    private val onPokemonClick: (Pokemon) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonImage: ImageView = itemView.findViewById(R.id.pokemonImage)
        val pokemonName: TextView = itemView.findViewById(R.id.pokemonName)
        val pokemonType: TextView = itemView.findViewById(R.id.pokemonType)
        val pokemonStats: TextView = itemView.findViewById(R.id.pokemonStats)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        
        // Load Pokemon image using Glide with better handling
        Glide.with(holder.itemView.context)
            .load(pokemon.sprites.frontDefault)
            .placeholder(R.drawable.pokemon_placeholder)
            .error(R.drawable.pokemon_placeholder)
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(holder.pokemonImage)

        // Set Pokemon name with custom styling
        holder.pokemonName.text = pokemon.name.capitalize()
        
        // Set Pokemon type
        val typeText = pokemon.types.joinToString(", ") { it.type.name.capitalize() }
        holder.pokemonType.text = "Type: $typeText"
        
        // Set Pokemon stats (HP and Attack)
        val hpStat = pokemon.stats.find { it.stat.name == "hp" }?.base_stat ?: 0
        val attackStat = pokemon.stats.find { it.stat.name == "attack" }?.base_stat ?: 0
        holder.pokemonStats.text = "HP: $hpStat | Attack: $attackStat"
        
        // Set click listener
        holder.itemView.setOnClickListener {
            onPokemonClick(pokemon)
        }
    }

    override fun getItemCount(): Int = pokemonList.size
    
    fun updatePokemonList(newList: List<Pokemon>) {
        pokemonList = newList
        notifyDataSetChanged()
    }
} 