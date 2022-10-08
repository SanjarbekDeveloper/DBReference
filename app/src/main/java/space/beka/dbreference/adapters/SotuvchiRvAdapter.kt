package space.beka.dbreference.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.beka.dbreference.databinding.ItemSotuvchiBinding
import space.beka.dbreference.models.Sotuvchi
import space.beka.dbreference.models.Xaridor
import java.lang.Exception

class SotuvchiRvAdapter<T>(var list: List<T>) :
    RecyclerView.Adapter<SotuvchiRvAdapter<T>.Vh>() {
    inner class Vh(var itemTvBinding: ItemSotuvchiBinding) :
        RecyclerView.ViewHolder(itemTvBinding.root) {

        fun onBindSotuvchi(sotuvchi: Sotuvchi, position: Int) {
            itemTvBinding.tvName.text = sotuvchi.name
            itemTvBinding.tvNumber.text = sotuvchi.number
        }

        fun onBindXaridor(xaridor: Xaridor, position: Int) {
            itemTvBinding.tvName.text = xaridor.name
            itemTvBinding.tvNumber.text = xaridor.number
            itemTvBinding.tvAddress.visibility = View.VISIBLE
            itemTvBinding.tvAddress.text = xaridor.address
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemSotuvchiBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        try {
            val sotuvchi: Sotuvchi = list[position] as Sotuvchi
            holder.onBindSotuvchi(sotuvchi, position)
        } catch (e: Exception) {

        }
        try {

            val xaridor: Xaridor = list[position] as Xaridor
            holder.onBindXaridor(xaridor, position)
        } catch (e: Exception) {

        }
    }

    override fun getItemCount(): Int = list.size


}