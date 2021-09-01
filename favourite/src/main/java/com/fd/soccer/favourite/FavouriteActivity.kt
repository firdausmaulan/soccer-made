package com.fd.soccer.favourite

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.fd.soccer.di.favouriteModule
import com.fd.soccer.favourite.databinding.FavouriteActivityBinding
import org.koin.core.context.GlobalContext.loadKoinModules

@Keep
class FavouriteActivity : AppCompatActivity() {

    private lateinit var binding: FavouriteActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FavouriteActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favouriteModule)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.title_favourite)
        val colorDrawable = ColorDrawable(
            ContextCompat.getColor(this, com.fd.core.R.color.purple_500)
        )
        supportActionBar?.setBackgroundDrawable(colorDrawable)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FavouriteFragment())
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}