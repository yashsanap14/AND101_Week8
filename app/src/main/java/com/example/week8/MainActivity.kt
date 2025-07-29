package com.example.week8

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week8.adapter.PokemonAdapter
import com.example.week8.api.PokeApiService
import com.example.week8.data.Pokemon
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    
    private lateinit var pokemonRecyclerView: RecyclerView
    private lateinit var loadingProgressBar: ProgressBar
    private lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var pokeApiService: PokeApiService
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        // Initialize views
        pokemonRecyclerView = findViewById(R.id.pokemonRecyclerView)
        loadingProgressBar = findViewById(R.id.loadingProgressBar)
        
        // Setup RecyclerView
        setupRecyclerView()
        
        // Setup API service
        setupApiService()
        
        // Load Pokemon data
        loadPokemonData()
    }
    
    private fun setupRecyclerView() {
        pokemonAdapter = PokemonAdapter(emptyList()) { pokemon ->
            // Handle Pokemon click
            Toast.makeText(this, "Selected: ${pokemon.name.capitalize()}", Toast.LENGTH_SHORT).show()
        }
        
        pokemonRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = pokemonAdapter
        }
    }
    
    private fun setupApiService() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        
        pokeApiService = retrofit.create(PokeApiService::class.java)
    }
    
    private fun loadPokemonData() {
        loadingProgressBar.visibility = View.VISIBLE
        
        lifecycleScope.launch {
            try {
                // Load many more Pokemon for a scrollable list
                val pokemonList = mutableListOf<Pokemon>()
                
                // Extended list of Pokemon for better scrolling
                val pokemonNames = listOf(
                    "ditto", "pikachu", "charizard", "bulbasaur", "squirtle",
                    "mewtwo", "mew", "jigglypuff", "snorlax", "gengar",
                    "blastoise", "venusaur", "alakazam", "machamp", "golem",
                    "dragonite", "gyarados", "lapras", "vaporeon", "jolteon",
                    "flareon", "aerodactyl", "kabutops", "omastar", "dodrio",
                    "muk", "weezing", "rhydon", "kangaskhan", "tauros"
                )
                
                for (name in pokemonNames) {
                    try {
                        val pokemon = pokeApiService.getPokemon(name)
                        pokemonList.add(pokemon)
                    } catch (e: Exception) {
                        // Skip failed Pokemon and continue
                        continue
                    }
                }
                
                // Update adapter with Pokemon data
                pokemonAdapter.updatePokemonList(pokemonList)
                
            } catch (e: Exception) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.error_loading),
                    Toast.LENGTH_LONG
                ).show()
            } finally {
                loadingProgressBar.visibility = View.GONE
            }
        }
    }
}