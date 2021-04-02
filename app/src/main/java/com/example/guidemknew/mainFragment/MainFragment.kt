package com.example.guidemknew.mainFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.guidemknew.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

private const val COUNT_COLOMN = 3

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val adapterHeroesMain = AdapterHeroesMain { position->
        Toast.makeText(context,position.toString(),Toast.LENGTH_SHORT).show()
    }
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    val viewModel: ViewModelMain by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        bindRecycler()
        bindProgressBar()
        observeMessage()
        return view
    }

    private fun observeMessage() {
        viewModel.message.observe(viewLifecycleOwner, {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun bindProgressBar() {
        lifecycleScope.launchWhenCreated {
            viewModel.listPerson
                .collect {
                    if (it.size == 0) {
                        binding.pbDownloadHeroes.visibility = View.VISIBLE
                        return@collect
                    }
                    binding.pbDownloadHeroes.visibility = View.GONE
                }
        }
    }

    private fun bindRecycler() {
        val layoutManager = GridLayoutManager(context, COUNT_COLOMN)
        binding.rvMainFragmentHeroes.layoutManager = layoutManager
        binding.rvMainFragmentHeroes.adapter = adapterHeroesMain
        binding.rvMainFragmentHeroes.visibility = View.GONE

        lifecycleScope.launchWhenCreated {
            viewModel.listPerson
                .collect {
                    if (it.size == 0) {
                        return@collect
                    }
                    binding.rvMainFragmentHeroes.visibility = View.VISIBLE
                    adapterHeroesMain.clear()
                    adapterHeroesMain.addItems(it)
                    adapterHeroesMain.notifyDataSetChanged()
                    Log.d("TAG", "observeListHeroes: ${it.size}")
                }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}