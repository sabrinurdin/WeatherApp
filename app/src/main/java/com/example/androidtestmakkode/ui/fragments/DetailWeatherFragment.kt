package com.example.androidtestmakkode.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.androidtestmakkode.R
import com.example.androidtestmakkode.databinding.FragmentDetailWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailWeatherFragment : Fragment() {
    private lateinit var binding: FragmentDetailWeatherBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailWeatherBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: DetailWeatherFragmentArgs by navArgs()

        args.let {
            binding.tvCondition.text = it.weatherResponse.current!!.condition!!.text
            binding.tvCelcius.text =
                it.weatherResponse.current!!.tempC!!.toDouble().toString() + " ºC"
            binding.tvFahrenheit.text =
                it.weatherResponse.current!!.tempF!!.toDouble().toString() + " ºF"

            binding.tvName.text = it.weatherResponse.location!!.name
            when (binding.tvName.text) {
                "Rappang" -> {
                    binding.clBackground.background =
                        ContextCompat.getDrawable(context!!, R.drawable.background)
                }
                "Parepare" -> {
                    binding.clBackground.background =
                        ContextCompat.getDrawable(context!!, R.drawable.background2)
                }
                "Makassar" -> {
                    binding.clBackground.background =
                        ContextCompat.getDrawable(context!!, R.drawable.background3)
                }
            }

            Glide.with(context!!)
                .load("https:${it.weatherResponse.current!!.condition!!.icon}")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_baseline_access_time_24)
                .error(R.drawable.ic_baseline_error_outline_24)
                .into(binding.ivWeather)

        }
    }
}