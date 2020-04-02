package com.ferdyhaspin.sayurmanjur.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
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
import com.google.gson.Gson
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


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
        //        delay(2000L)
        val data = Gson().fromJson(parseJson(), VegetableData::class.java)
        initRecyclerView(data.fruits, rvFruit)
        initRecyclerView(data.vegetables, rvVegetable)
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
            R.id.action_user -> toast("Test")
        }
        return super.onOptionsItemSelected(item)
    }
}
