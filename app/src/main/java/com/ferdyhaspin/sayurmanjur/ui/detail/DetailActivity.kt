package com.ferdyhaspin.sayurmanjur.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ferdyhaspin.sayurmanjur.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbar.title = getString(R.string.app_name)
    }
}
