package com.example.marvel.ui.screen.characters

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.data.db.SearchedNames
import com.example.marvel.ui.base.AbsFragment
import com.example.marvel.ui.screen.characters.adapter.CharactersAdapter
import kotlinx.android.synthetic.main.fragment_characters.*
import kotlin.reflect.KClass

class CharactersFragment : AbsFragment<CharactersViewModel>() {

    private val adapter by lazy {
        CharactersAdapter(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcCharacters.adapter = adapter

        viewModel?.liveData?.observe(viewLifecycleOwner, {
            adapter.setData(it)
            Log.e("TAG", it.toString())
        })

        viewModel?.allLiveData?.observe(viewLifecycleOwner, {
            adapter.setAllData(it)
        })

        //viewModel?.fetchCharacter()



        rcCharacters.setOnScrollChangeListener(object : View.OnScrollChangeListener {
            override fun onScrollChange(p0: View?, p1: Int, p2: Int, p3: Int, p4: Int) {

                Log.e("Hi", "Its working")
                if (isLastVisible()) {
                    Log.e("Hi", isLastVisible().toString())
                    viewModel?.fetchCharacter()
                }

            }

        })

        rcCharacters.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (isLastVisible()) {
                    viewModel?.fetchCharacter()
                }
                Log.e("Hi", "Its working")
            }
        })

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_search, menu)

        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    rcCharacters.scrollToPosition(0)
                    viewModel?.saveSearchedName(SearchedNames(name = query))
                    viewModel?.searchCharacter(query)
                    searchView.clearFocus()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }

    fun isLastVisible(): Boolean {
        val layoutManager = rcCharacters.layoutManager as LinearLayoutManager
        val pos = layoutManager.findLastCompletelyVisibleItemPosition()
        val numItems: Int = rcCharacters.adapter!!.itemCount
        return pos >= numItems -1
    }


    override fun provideLayoutId() = R.layout.fragment_characters

    override fun provideViewModelClass(): KClass<CharactersViewModel> = CharactersViewModel::class
}