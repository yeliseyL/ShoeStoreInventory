package com.eliseylobanov.shoestoreinventory.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.eliseylobanov.shoestoreinventory.R
import com.eliseylobanov.shoestoreinventory.databinding.ShoeListingFragmentBinding
import com.eliseylobanov.shoestoreinventory.models.Shoe
import com.eliseylobanov.shoestoreinventory.viewmodels.ShoeListingViewModel

class ShoeListingFragment : Fragment() {
    lateinit var binding: ShoeListingFragmentBinding
    private val viewModel: ShoeListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ShoeListingFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.shoes.observe(viewLifecycleOwner) {
            it.forEach { shoe -> addShoeToList(shoe) }
        }

        binding.fab.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_shoeListingFragment_to_shoeDetailFragment)
        )
    }

    private fun addShoeToList(shoe: Shoe) {
        val card = CardView(requireContext())
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT).also {
            it.setMargins(24, 24, 24, 24)
        }
        card.layoutParams = params
        card.setCardBackgroundColor(resources.getColor(R.color.purple_200))

        val textView = TextView(requireContext())
        textView.layoutParams = params
        textView.text = "${shoe.company} ${shoe.name} ${shoe.size} \n\n${shoe.description}"

        card.addView(textView)
        binding.shoeList.addView(card)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                view?.findNavController()
                        ?.navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToLoginFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}