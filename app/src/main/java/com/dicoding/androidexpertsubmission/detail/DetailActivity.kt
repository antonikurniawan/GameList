package com.dicoding.androidexpertsubmission.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.androidexpertsubmission.R
import com.dicoding.core.domain.model.GameRate
import com.dicoding.androidexpertsubmission.databinding.ActivityDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.menu_detail)


        val detailGameRate = intent.getParcelableExtra<GameRate>(EXTRA_DATA)
        showDetailGameRate(detailGameRate)
    }

    private fun showDetailGameRate(detailGameRate: GameRate?) {
        detailGameRate?.let {

            //data image
            Glide.with(this@DetailActivity)
                .load(detailGameRate.backgroundImage)
                .into(binding.imageDetailGame)

            //data text
            binding.textDataName.text = detailGameRate.name
            binding.textDataRating.text = detailGameRate.rating
            binding.textDataRatingCount.text = detailGameRate.ratingsCount.toString()
            binding.textDataReleased.text = detailGameRate.released
            binding.textDataPlaytime.text = detailGameRate.playtime.toString()
            binding.textDataMetacritic.text = detailGameRate.metacritic.toString()

            //button favorite
            var statusFavorite = detailGameRate.isFavorite
            setStatusFavorite(statusFavorite)
            binding.floatButtonFavorite.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteGameRate(detailGameRate, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.floatButtonFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
        } else {
            binding.floatButtonFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite))
        }
    }
}