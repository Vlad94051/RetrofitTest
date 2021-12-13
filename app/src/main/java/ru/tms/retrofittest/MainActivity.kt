package ru.tms.retrofittest

import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel : MainViewModel by viewModel()

    override fun onStart() {
        super.onStart()
        viewModel.news.observe(this) { news ->
            val art = news.articles.first()
            Log.e("!!!", art.toString())
            Toast.makeText(this, art.title.orEmpty(), Toast.LENGTH_LONG).show()
        }
    }

}