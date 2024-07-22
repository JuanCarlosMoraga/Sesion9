package com.moraga.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.moraga.myapplication.adapter.CityAdapter
import com.moraga.myapplication.adapter.CityViewModel
import com.moraga.myapplication.adapter.CityViewModelFactory
import com.moraga.myapplication.dao.DataBaseBuilder
import com.moraga.myapplication.databinding.FragmentListCityBinding


class ListCityFragment : Fragment() {

    private lateinit var binding: FragmentListCityBinding


    private val cityViewModel : CityViewModel by viewModels{
        CityViewModelFactory(DataBaseBuilder.getIntance(requireContext()).CityDao())
    }

    private lateinit var cityListAdapter: CityAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListCityBinding.inflate(layoutInflater)
        startList()
        return binding.root
    }

    private fun startList() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listCityFragment_to_newCityFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cityListAdapter = CityAdapter(requireContext(), emptyList())
        binding.lvRegistros.adapter = cityListAdapter

        cityViewModel.allCities.observe(viewLifecycleOwner, Observer {
            cities -> cityListAdapter.updateCities(cities)
        })
    }
}