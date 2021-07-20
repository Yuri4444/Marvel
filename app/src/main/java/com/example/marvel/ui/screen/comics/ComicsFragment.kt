package com.example.marvel.ui.screen.comics

import android.os.Bundle
import android.view.View
import com.example.marvel.R
import com.example.marvel.ui.base.AbsFragment
import com.example.marvel.ui.screen.characters.adapter.CharactersAdapter
import kotlinx.android.synthetic.main.fragment_comics.*
import kotlin.reflect.KClass

class ComicsFragment : AbsFragment<ComicsViewModel>() {

    private val adapter by lazy {
        CharactersAdapter(requireContext())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvComics.adapter = adapter


        viewModel?.livedata?.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })

        viewModel?.fetchComics()
    }

    override fun provideLayoutId() = R.layout.fragment_comics

    override fun provideViewModelClass(): KClass<ComicsViewModel> = ComicsViewModel::class
}