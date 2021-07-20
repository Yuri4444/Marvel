package com.example.marvel.ui.screen.characters

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import com.example.marvel.R
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
        viewModel?.fetchCharacter()

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


    override fun provideLayoutId() = R.layout.fragment_characters

    override fun provideViewModelClass(): KClass<CharactersViewModel> = CharactersViewModel::class
}