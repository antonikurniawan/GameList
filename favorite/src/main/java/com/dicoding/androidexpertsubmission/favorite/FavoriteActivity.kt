package com.dicoding.androidexpertsubmission.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.androidexpertsubmission.detail.DetailActivity
import com.dicoding.androidexpertsubmission.favorite.databinding.ActivityFavoriteBinding
import com.dicoding.androidexpertsubmission.favorite.di.favoriteModule
import com.dicoding.core.ui.GameRateAdapter
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        supportActionBar?.title = getString(R.string.menu_favorite)


        val gameRateAdapter = GameRateAdapter()
        gameRateAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteGameRate.observe(this, { dataGameRate ->
            gameRateAdapter.setData(dataGameRate)
            binding.viewEmpty.root.visibility = if(dataGameRate.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.recyclerViewGameRate) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = gameRateAdapter
        }

    }
}