package com.example.mvvm.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.databinding.ContentDogsListBinding
import com.example.mvvm.databinding.ContentLoginBinding
import com.example.mvvm.ui.dogslist.DogsList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Login : Fragment() {

    private lateinit var binding: ContentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ContentLoginBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            btnSkip.setOnClickListener {
                view?.findNavController()?.navigate(R.id.actionSkip)
            }
        }
        return binding.root
    }
}