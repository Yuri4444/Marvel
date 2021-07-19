package com.example.marvel.ui.screen.characters

import android.os.Bundle
import android.util.Log
import android.view.View
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

        viewModel?.fetch()
    }


    override fun provideLayoutId() = R.layout.fragment_characters

    override fun provideViewModelClass(): KClass<CharactersViewModel> = CharactersViewModel::class
}