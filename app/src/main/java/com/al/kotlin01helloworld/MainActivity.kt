package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.al.kotlin01helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PoemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 隐藏 ActionBar
        // supportActionBar?.hide()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val spacingInPixels = 8
        binding.rvPoem.addItemDecoration(SpacesItemDecoration(spacingInPixels))
        adapter = PoemAdapter(PoemLibrary.getPoemList())
        binding.rvPoem.layoutManager = LinearLayoutManager(this)

        binding.rvPoem.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.layout_manager, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.mnuGridLayout -> changeToGridLayout()
            R.id.mnuLinerLayout -> changeToLinerLayout()
            R.id.mnuStaggerLayout -> changeToStaggerLayout()
        }
        return true
    }

    private fun changeToGridLayout() {
        binding.rvPoem.layoutManager = GridLayoutManager(this, 2)
        binding.rvPoem.adapter = adapter
    }

    private fun changeToLinerLayout() {
        binding.rvPoem.layoutManager = LinearLayoutManager(this)
        binding.rvPoem.adapter = adapter
    }

    private fun changeToStaggerLayout() {
        binding.rvPoem.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvPoem.adapter = adapter
    }
}