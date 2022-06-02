package mx.edu.itm.link.reto_getsimplerequest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.edu.itm.link.reto_getsimplerequest.databinding.ItemPokemonitoBinding
import org.json.JSONArray
import org.json.JSONObject

class MainAdapter(private val pokemons: JSONArray): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemPokemonitoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(pokemons.getJSONObject(position))
    }

    override fun getItemCount(): Int = pokemons.length()

    class MainHolder(val binding: ItemPokemonitoBinding): RecyclerView.ViewHolder(binding.root){
        fun render(pokemon: JSONObject){
            binding.tvPokemonName.setText(pokemon.getString("name"))
        }
    }
}