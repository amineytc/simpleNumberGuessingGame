package com.amine.simplenumberguessinggame

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*
import kotlin.random.Random

class SecondFragment : Fragment() {

    private var randomNumber = 0
    private var counter =5
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val design = inflater.inflate(R.layout.fragment_second, container, false)
        randomNumber = Random.nextInt(101) // number between 0 and 100
        Log.e("Random Number:", randomNumber.toString())
        design.buttonPrediction.setOnClickListener {
            counter -= 1
            var prediction = editTextEntry.text.toString().toInt()
            if(prediction==randomNumber){
                val transition = SecondFragmentDirections.switchtoResultsScreen("true")
                Navigation.findNavController(it).navigate(transition)
                return@setOnClickListener
            }
            if(prediction > randomNumber) {
                design.textViewHelp.text = "Reduce"
                design.textViewRemainder.text = "Remaining Right : $counter"
            }
            if(prediction < randomNumber){
                design.textViewHelp.text = "Increase"
                design.textViewRemainder.text = "Remaining Right : $counter"
            }
            if(counter ==0){
                val transition = SecondFragmentDirections.switchtoResultsScreen("false")
                Navigation.findNavController(it).navigate(transition)
            }
            editTextEntry.setText("")
            // Navigation.findNavController(it).navigate(R.id.switchtoResultsScreen)
        }
        return design
    }
}