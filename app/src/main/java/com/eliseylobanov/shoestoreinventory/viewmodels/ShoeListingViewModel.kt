package com.eliseylobanov.shoestoreinventory.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eliseylobanov.shoestoreinventory.models.Shoe

class ShoeListingViewModel : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    init {
        _shoes.value = mutableListOf(
                Shoe("Air Max", "45.0", "Nike", "This clean, pure white finish adds the gum sole" +
                        "contrast for a fresh, versatile look with just the right amount of pop."),

                Shoe("Air Force", "37.5", "Nike", "This clean, pure white finish adds the gum sole" +
                        "contrast for a fresh, versatile look with just the right amount of pop."),

                Shoe("Blazer Mid '77", "42.5", "Nike", "This clean, pure white finish adds the gum sole" +
                        "contrast for a fresh, versatile look with just the right amount of pop.")
        )
    }

    fun addShoe(shoe: Shoe?) {
        shoe?.let {
            _shoes.value?.add(shoe)
        }
    }
}