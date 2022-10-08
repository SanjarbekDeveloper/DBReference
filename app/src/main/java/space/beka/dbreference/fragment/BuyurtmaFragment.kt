package space.beka.dbreference.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import space.beka.dbreference.R
import space.beka.dbreference.databinding.FragmentBuyurtmaBinding
import space.beka.dbreference.databinding.ItemDialogOrdersBinding
import space.beka.dbreference.db.MyDbHelper
import space.beka.dbreference.models.Buyurtma
import space.beka.dbreference.models.Sotuvchi
import space.beka.dbreference.models.Xaridor
import space.sanjar.dbreference.adapters.BuyurtmaAdapter

class BuyurtmaFragment : Fragment() {
    private lateinit var binding: FragmentBuyurtmaBinding
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var list: ArrayList<Buyurtma>
    private lateinit var buyurtmaAdapter: BuyurtmaAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuyurtmaBinding.inflate(layoutInflater)
        myDbHelper = MyDbHelper(context)
        list = ArrayList()
        list.addAll(myDbHelper.getAllOrders())
        buyurtmaAdapter = BuyurtmaAdapter(list)
        binding.rvBuyurtma.adapter = buyurtmaAdapter
        addBuyurtma()
        return binding.root
    }

    private fun addBuyurtma() {
        binding.btnAdd.setOnClickListener {
            val dialog = AlertDialog.Builder(binding.root.context).create()
            val itemDialogOrdersBinding = ItemDialogOrdersBinding.inflate(layoutInflater)
            dialog.setView(itemDialogOrdersBinding.root)
            dialog.show()
            val listSotuvchi = myDbHelper.getAllSalesman()
            val listSotuvchiName = ArrayList<String>()
            listSotuvchi.forEach {
                listSotuvchiName.add(it.name)
            }
            val sAdapter = ArrayAdapter<String>(
                binding.root.context,
                android.R.layout.simple_list_item_1,
                listSotuvchiName
            )
            itemDialogOrdersBinding.spinnerSotuvchi.adapter = sAdapter


            val listXaridor = myDbHelper.getAllCustomer()
            val listXaridorName = ArrayList<String>()
            listXaridor.forEach {
                listXaridorName.add(it.name)
            }
            val xAdapter = ArrayAdapter<String>(
                binding.root.context,
                android.R.layout.simple_list_item_1,
                listXaridorName
            )
            itemDialogOrdersBinding.spinnerXaridor.adapter = xAdapter

            itemDialogOrdersBinding.btnSave.setOnClickListener {
                val buyurtma = Buyurtma(
                    itemDialogOrdersBinding.edtName.text.toString(),
                    itemDialogOrdersBinding.edtPrice.text.toString().toInt(),
                    listSotuvchi[itemDialogOrdersBinding.spinnerSotuvchi.selectedItemPosition],
                    listXaridor[itemDialogOrdersBinding.spinnerXaridor.selectedItemPosition]
                )
                myDbHelper.addOrder(buyurtma)
                list.add(buyurtma)
                buyurtmaAdapter.notifyItemInserted(list.size - 1)
                Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
            }
        }
    }

}