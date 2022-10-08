package space.beka.dbreference.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import space.beka.dbreference.adapters.SotuvchiRvAdapter
import space.beka.dbreference.databinding.FragmentSotuvBinding
import space.beka.dbreference.databinding.ItemDialogBinding
import space.beka.dbreference.db.MyDbHelper
import space.beka.dbreference.models.Sotuvchi


class SotuvFragment : Fragment() {
    private lateinit var binding: FragmentSotuvBinding
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var sotuvchiRvAdapter: SotuvchiRvAdapter<Sotuvchi>
    private lateinit var list: ArrayList<Sotuvchi>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSotuvBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(context)
        list = ArrayList()
        list.addAll(myDbHelper.getAllSalesman())
        sotuvchiRvAdapter = SotuvchiRvAdapter(list)
        binding.rv.adapter = sotuvchiRvAdapter

        binding.btnAdd.setOnClickListener {
            val dialog = AlertDialog.Builder(binding.rv.context).create()
            val itemDialogBinding = ItemDialogBinding.inflate(layoutInflater)
            dialog.setView(itemDialogBinding.root)
            dialog.show()
            itemDialogBinding.btnSave.setOnClickListener {
                val sotuvchi = Sotuvchi(
                    itemDialogBinding.edtName.text.toString(),
                    itemDialogBinding.edtNumber.text.toString()
                )
                myDbHelper.addSalesman(sotuvchi)
                list.add(sotuvchi)
                sotuvchiRvAdapter.notifyItemInserted(list.size - 1)
                Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }

        }
            return binding.root
        }


}