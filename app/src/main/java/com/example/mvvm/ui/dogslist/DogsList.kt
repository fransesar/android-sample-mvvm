package com.example.mvvm.ui.dogslist

import android.R
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.databinding.ContentDogsListBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DogsListFragment : Fragment() {
    private lateinit var binding: ContentDogsListBinding
    private val viewModel: DogsViewModel by viewModels()
    private val dogsAdapter = DogsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ContentDogsListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            rv.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = dogsAdapter
            }
        }

        viewModel.getDogs()
        viewModel.dogs.observe(viewLifecycleOwner, Observer {
            dogsAdapter.submitList(it)
        })

        return binding.root
    }
}
