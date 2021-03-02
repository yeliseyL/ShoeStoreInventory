package com.eliseylobanov.shoestoreinventory.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.eliseylobanov.shoestoreinventory.R
import com.eliseylobanov.shoestoreinventory.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment)
        )

        binding.signupButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment)
        )
    }
}