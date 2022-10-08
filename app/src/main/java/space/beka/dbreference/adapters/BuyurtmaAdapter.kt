package space.sanjar.dbreference.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.beka.dbreference.databinding.ItemSotuvchiBinding
import space.beka.dbreference.models.Buyurtma


class BuyurtmaAdapter(var list: List<Buyurtma>) : RecyclerView.Adapter<BuyurtmaAdapter.Vh>() {
    inner class Vh(var itemTvBinding: ItemSotuvchiBinding) :
        RecyclerView.ViewHolder(itemTvBinding.root) {
        fun onBind(buyurtma: Buyurtma, position: Int) {
            itemTvBinding.tvName.text = buyurtma.name
            itemTvBinding.tvNumber.text = buyurtma.price.toString()
            itemTvBinding.tvAddress.visibility = View.VISIBLE
            itemTvBinding.tvAddress.text = buyurtma.sotuvchi?.name
            itemTvBinding.tvXaridor.visibility = View.VISIBLE
            itemTvBinding.tvXaridor.text = buyurtma.xaridor?.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemSotuvchiBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size


}