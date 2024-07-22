package com.moraga.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.moraga.myapplication.dao.DataBaseBuilder
import com.moraga.myapplication.databinding.FragmentNewCityBinding
import com.moraga.myapplication.entities.City
import kotlinx.coroutines.launch


class NewCityFragment : Fragment() {

    lateinit var binding: FragmentNewCityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewCityBinding.inflate(layoutInflater)
        startCity()
        return binding.root
    }

    private fun startCity() {
        binding.btnSave.setOnClickListener{
            saveCity()
        }
    }

    private fun saveCity() {
        val context = requireContext()
        val db = DataBaseBuilder.getIntance(context)
        val cityDao = db.CityDao()
        val name = binding.tfName.editText?.text.toString()
        val description = binding.tfDescription.editText?.text.toString()
        val population = binding.tfPopulation.editText?.text.toString().toInt()
        val city = City(0, name, description, population)
        viewLifecycleOwner.lifecycleScope.launch {
            cityDao.insert(city)
        }
        binding.tfName.editText?.setText("")
        binding.tfDescription.editText?.setText("")
        binding.tfPopulation.editText?.setText("")
        binding.tfName.requestFocus()
        findNavController().popBackStack()
    }
}