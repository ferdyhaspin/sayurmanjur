package com.ferdyhaspin.sayurmanjur.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ferdyhaspin.sayurmanjur.R
import com.ferdyhaspin.sayurmanjur.model.Vegetable
import com.ferdyhaspin.sayurmanjur.util.Constant
import com.ferdyhaspin.sayurmanjur.util.loadLocal
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initToolbar()
        initView()
    }

    private fun initView() {
        intent.getParcelableExtra<Vegetable>(Constant.VEGETABLE)?.let {
            tvName.text = it.name
            tvNameEn.text = it.nameEn
            tvDescription.text = it.desc
            tvBenefit.text = it.benefit
            rivPhoto.loadLocal(it.photo)
        }
    }

    private fun initToolbar() {
        toolbar.title = ""
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
