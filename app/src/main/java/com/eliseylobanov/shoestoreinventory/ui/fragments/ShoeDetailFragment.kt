package com.eliseylobanov.shoestoreinventory.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.eliseylobanov.shoestoreinventory.R
import com.eliseylobanov.shoestoreinventory.databinding.ShoeDetailFragmentBinding
import com.eliseylobanov.shoestoreinventory.models.Shoe
import com.eliseylobanov.shoestoreinventory.viewmodels.ShoeListingViewModel

class ShoeDetailFragment : Fragment() {
    lateinit var binding: ShoeDetailFragmentBinding
    private val viewModel: ShoeListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ShoeDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.newShoe = Shoe("", "", "", "")

        binding.cancelButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListingFragment)
        )

        binding.saveButton.setOnClickListener {
            createNewShoeItem()
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListingFragment)
        }
    }

    private fun createNewShoeItem() {
        viewModel.addShoe(binding.newShoe)
    }

}