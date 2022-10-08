package space.beka.dbreference.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import space.beka.dbreference.R
import space.beka.dbreference.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.btnSotuvchi.setOnClickListener {
            findNavController().navigate(R.id.sotuvFragment)
        }
        binding.btnXaridor.setOnClickListener {
            findNavController().navigate(R.id.xaridFragment)
        }
        binding.btnBuyurtma.setOnClickListener {
            findNavController().navigate(R.id.buyurtmaFragment)
        }
        return binding.root
    }


}