package com.ferdyhaspin.sayurmanjur.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ferdyhaspin.sayurmanjur.R
import com.ferdyhaspin.sayurmanjur.model.Vegetable
import com.ferdyhaspin.sayurmanjur.util.Constant
import kotlinx.android.synthetic.main.activity_detail.*

//import kotlinx.android.synthetic.main.toolbar.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        val explode = Fade()
//        explode.excludeTarget(android.R.id.statusBarBackground, true)
//        explode.excludeTarget(R.id.appBarLayout, true)
//        explode.excludeTarget(android.R.id.navigationBarBackground, true)
//        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
//        window.enterTransition = explode
//        window.exitTransition = explode
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
            val image = resources.getIdentifier(
                it.photo,
                "drawable",
                packageName
            )
            rivPhoto.background = resources.getDrawable(image, null)
        }
    }

    private fun initToolbar() {
        toolbar.title = ""
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setHomeAsUpIndicator(R.drawable.ic_back)
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
