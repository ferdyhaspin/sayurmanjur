package com.ferdyhaspin.sayurmanjur.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ferdyhaspin.sayurmanjur.R
import com.ferdyhaspin.sayurmanjur.model.Vegetable
import com.ferdyhaspin.sayurmanjur.model.VegetableData
import com.ferdyhaspin.sayurmanjur.ui.detail.DetailActivity
import com.ferdyhaspin.sayurmanjur.util.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.Gson
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.coroutines.delay


class MainActivity : AppCompatActivity(), RecyclerViewCallback.OnCLick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        getData()
    }

    private fun initView() {
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)
    }

    private fun getData() = main {
        showLoading(true)
        delay(2000L)
        showLoading(false)
        val data = Gson().fromJson(parseJson(), VegetableData::class.java)
        initRecyclerView(data.fruits, rvFruit)
        initRecyclerView(data.vegetables, rvVegetable)
    }

    private fun showLoading(show: Boolean) {
        if (show) {
            loading.startShimmerAnimation()
            loading.toVisible()
            content.toGone()
        } else {
            loading.stopShimmerAnimation()
            loading.toGone()
            content.toVisible()
        }
    }


    private fun initRecyclerView(list: List<Vegetable>, rv: RecyclerView) {
        val mAdapter = GroupAdapter<ViewHolder>().apply {
            val data = list.map {
                VegetableItem(it, this@MainActivity)
            }
            addAll(data)
        }

        rv.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = mAdapter
        }
    }

    override fun onItemClickListener(vararg view: View, item: Vegetable) {
        val image = Pair(view[0], "detail_image")
        val name = Pair(view[1], "detail_name")
        val nameEn = Pair(view[2], "detail_name_en")
        val activityOptionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(this, image, name, nameEn)
        Intent(this, DetailActivity::class.java).apply {
            putExtra(Constant.VEGETABLE, item)
            startActivity(this, activityOptionsCompat.toBundle())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_user -> showProfile()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showProfile() {
        val view = layoutInflater.inflate(R.layout.bottom_detail_account, root, false)
        val dialog = BottomSheetDialog(this)
        dialog.setOnShowListener { dialogs ->
            val d = dialogs as BottomSheetDialog
            val bottomSheet =
                d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
        }
        dialog.setContentView(view)
        dialog.show()
    }
}
