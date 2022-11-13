package com.amine.simplenumberguessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_first.view.*


class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val design = inflater.inflate(R.layout.fragment_first, container, false)

        design.buttonStart.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.switchtoForecastScreen)

        }
        return design
    }

}