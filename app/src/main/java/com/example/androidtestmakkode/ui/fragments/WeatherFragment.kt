package com.example.androidtestmakkode.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.androidtestmakkode.R
import com.example.androidtestmakkode.databinding.FragmentWeatherBinding
import com.example.androidtestmakkode.utils.CustomProgressDialog
import com.example.androidtestmakkode.utils.Resource
import com.example.androidtestmakkode.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding

    private lateinit var progressBar: CustomProgressDialog

    private val viewModel: MainViewModel by activityViewModels()

    override fun onResume() {
        super.onResume()
        val aLocation = resources.getStringArray(R.array.location_array)
        val adapter =
            ArrayAdapter(context!!, android.R.layout.simple_dropdown_item_1line, aLocation)

        binding.tvLocation.setAdapter(adapter)
        Log.d("TAGFRAGMENT", "onResume")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        Log.d("TAGFRAGMENT","onCreateView")
        binding = FragmentWeatherBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAGFRAGMENT","onViewCreate")
        progressBar = CustomProgressDialog(requireActivity())

        binding.button.setOnClickListener {
            //Toast.makeText(context,"gukgk",Toast.LENGTH_SHORT).show()
            getObserveDataWeather(
                binding.edtApiKey.text.toString(),
                binding.tvLocation.text.toString()
            )
        }
    }

    private fun getObserveDataWeather(key: String, location: String) {
        viewModel.getWeather(key, location)
        viewModel.weatherResponse.observe(viewLifecycleOwner, { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        progressBar.hideProgressDialog()
                        val action =
                            WeatherFragmentDirections.actionWeatherFragmentToDetailWeatherFragment(
                               it
                            )
                        findNavController().navigate(action)
                    }
                }
                is Resource.Loading -> {
                    progressBar.showProgressDialog()
                }

                is Resource.Error -> {
                    progressBar.hideProgressDialog()
                    response.message?.let {
                        Snackbar.make(binding.root, "Error $it", Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}