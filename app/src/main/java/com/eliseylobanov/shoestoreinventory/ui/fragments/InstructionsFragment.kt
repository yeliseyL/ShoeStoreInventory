package com.eliseylobanov.shoestoreinventory.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.eliseylobanov.shoestoreinventory.R
import com.eliseylobanov.shoestoreinventory.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.instructionsNextButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_instructionsFragment_to_shoeListingFragment)
        )
    }
}