package com.habijanic.hogwartsselection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat


class HouseFragment : Fragment() {

    lateinit var image : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View=inflater.inflate(R.layout.fragment_house, container, false)

        image = view.findViewById(R.id.imageViewHouse)
        val layout : ConstraintLayout = view.findViewById(R.id.house)

        val position = arguments?.getInt("position",0)

        when(position){

            0->image.setImageResource(R.drawable.gryffindor)
            1->image.setImageResource(R.drawable.hufflepuff)
            2->image.setImageResource(R.drawable.ravenclaw)
            3->image.setImageResource(R.drawable.slytherin)

        }
        when(position){

            0 ->layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.gryffindor_dark))
            1 ->layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.hufflepuff_dark))
            2 ->layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.ravenclaw_dark))
            3 ->layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.slytherin_dark))

        }

        // Inflate the layout for this fragment
        return view
    }


}