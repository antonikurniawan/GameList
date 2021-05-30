package com.dicoding.androidexpertsubmission.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.androidexpertsubmission.R
import com.dicoding.core.data.Resource
import com.dicoding.core.ui.GameRateAdapter
import com.dicoding.androidexpertsubmission.databinding.FragmentHomeBinding
import com.dicoding.androidexpertsubmission.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val gameRateAdapter = GameRateAdapter()
            gameRateAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }


            homeViewModel.gameRate.observe(viewLifecycleOwner, { gameRate ->
                if (gameRate != null) {
                    when(gameRate) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            gameRateAdapter.setData(gameRate.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.textError.text = gameRate.message ?: getString(R.string.page_error)
                        }
                    }
                }

            })

            with(binding.recyclerViewGameRate) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = gameRateAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}