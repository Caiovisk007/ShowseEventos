package com.example.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teste.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        configTablayout()
    }

    private fun configTablayout(){
        val adapter = ViewPageAdapter(this)
        binding.viewPager.adapter = adapter

        adapter.addFragment(SearchFragment(),"Pesquisar")
        adapter.addFragment(FavoritesFragment(),"Favoritos")

        binding.viewPager.offscreenPageLimit = adapter.itemCount

        val mediator = TabLayoutMediator(
            binding.tabs, binding.viewPager
        ){tab: TabLayout.Tab, position: Int ->
          tab.text = adapter.getTitle(
              position
          )
        }
        mediator.attach()
    }
}