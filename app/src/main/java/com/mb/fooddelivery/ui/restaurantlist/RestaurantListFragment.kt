package com.mb.fooddelivery.ui.restaurantlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mb.fooddelivery.R
import com.mb.fooddelivery.databinding.FragmentRestaurantListBinding
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantListFragment : Fragment() {
    private lateinit var binding  : FragmentRestaurantListBinding
    private val viewModel : RestaurantListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRestaurantListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getRestaurantList()
    }

    private fun getRestaurantList() {
        viewModel.getAllRestaurants().observe(viewLifecycleOwner,{
            when(it.status){
                Resource.Status.SUCCESS -> Log.i("Mert","succes -> ${it.data}")
            }
        })
    }
}