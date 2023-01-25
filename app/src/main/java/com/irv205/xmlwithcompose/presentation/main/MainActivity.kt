package com.irv205.xmlwithcompose.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.irv205.xmlwithcompose.core.utils.observe
import com.irv205.xmlwithcompose.databinding.ActivityMainBinding
import com.irv205.xmlwithcompose.presentation.MainViewModel
import com.irv205.xmlwithcompose.presentation.MainViewState
import com.irv205.xmlwithcompose.presentation.main.adapter.MainAdapterXML
import com.irv205.xmlwithcompose.presentation.main.adapter.MyComposeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private val adapterXML by lazy { MainAdapterXML() }
    private val adapterCompose by lazy { MyComposeAdapter() }
    private var selectedTab = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.apply {
            observe(mainViewState, ::onViewStateChanged)
        }
        setUpView()
    }

    private fun setUpView() {
        setUpTabLayout()
        binding.SwipeList.setOnRefreshListener {
            binding.SwipeList.isRefreshing = false
            viewModel.getCharacterList(1)
        }

        if (selectedTab == 0) {
            binding.rvItem.adapter = adapterXML
            adapterXML.submitList(viewModel.list)
        }

        paginationMethod()

    }

    private fun setUpTabLayout() {

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    selectedTab = tab.position
                }
                when(selectedTab){
                    0 -> {
                        binding.rvItem.adapter = adapterXML
                        adapterXML.submitList(viewModel.list)
                    }
                    1 -> {
                        binding.rvItem.adapter = adapterCompose
                        adapterCompose.items = viewModel.list
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Write code to handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Write code to handle tab reselect
            }
        })
    }

    private fun onViewStateChanged(viewState: MainViewState?){
        when(viewState){
            MainViewState.EmptyList -> {}
            MainViewState.GetCharacter -> {
                adapterXML.notifyDataSetChanged()
                adapterCompose.notifyDataSetChanged()
            }
            is MainViewState.ShowProgress -> {
                if (viewState.show){

                } else {

                }
            }
            else -> {}
        }
    }

    private fun paginationMethod() {
        binding.rvItem.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = LinearLayoutManager::class.java.cast(recyclerView.layoutManager)
                super.onScrolled(recyclerView, dx, dy)
                val totalItemList = viewModel.list.size
                val lastVisible = layoutManager?.findLastVisibleItemPosition()

                lastVisible?.let {
                    val endList = lastVisible + 5 >= totalItemList
                    if (endList) viewModel.setPaginationValue()
                }
            }
        })
    }

}