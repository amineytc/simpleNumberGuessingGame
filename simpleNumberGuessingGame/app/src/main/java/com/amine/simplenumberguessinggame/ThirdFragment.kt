package com.amine.simplenumberguessinggame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_third.*
import kotlinx.android.synthetic.main.fragment_third.view.*

class ThirdFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val design = inflater.inflate(R.layout.fragment_third, container, false)

        val bundle: ThirdFragmentArgs by navArgs()
        var incomingResult= bundle.results.toBoolean()
        if(incomingResult){
            design.textViewResult.text="Congratulations You Won"
            design.imageViewResult.setImageResource(R.drawable.happy)
        }else{
            design.textViewResult.text="You Loss"
            design.imageViewResult.setImageResource(R.drawable.sad)
        }

        design.buttonAgain.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.returntoHomePage)

        }
        return design
    }


}