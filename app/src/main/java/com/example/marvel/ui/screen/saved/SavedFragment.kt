package com.example.marvel.ui.screen.saved

import android.os.Bundle
import android.view.View
import com.example.marvel.R
import com.example.marvel.ui.base.AbsFragment
import com.example.marvel.ui.screen.saved.adapter.SavedNamesAdapter
import kotlinx.android.synthetic.main.fragment_saved.*
import kotlin.reflect.KClass

class SavedFragment : AbsFragment<SavedViewModel>() {

    private val adapter by lazy { SavedNamesAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcSaved.adapter = adapter

        viewModel?.savedNamesLiveData?.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })

        viewModel?.getAllSavedNames()

    }

    override fun provideLayoutId(): Int = R.layout.fragment_saved

    override fun provideViewModelClass(): KClass<SavedViewModel> = SavedViewModel::class
}