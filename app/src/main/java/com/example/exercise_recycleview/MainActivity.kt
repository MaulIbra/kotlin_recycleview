package com.example.exercise_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_recycleview.language.adapter.ILanguageRecycleListener
import com.example.exercise_recycleview.language.adapter.LanguageRecycleAdapter
import com.example.exercise_recycleview.language.viewmodel.LanguageViewModel
import kotlinx.android.synthetic.main.contain_main.*

class MainActivity : AppCompatActivity(), ILanguageRecycleListener {

    val languageViewModel by viewModels<LanguageViewModel>()
    lateinit var languageRecycleAdapter: LanguageRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contain_main)
        rvLanguage.layoutManager = LinearLayoutManager(this)
        languageRecycleAdapter = LanguageRecycleAdapter(languageViewModel.languageLiveData.value!!)
        languageRecycleAdapter.listener = this
        rvLanguage.adapter = languageRecycleAdapter
        languageViewModel.languageLiveData.observe(this, Observer {
            languageRecycleAdapter.notifyDataSetChanged()
        })
    }

    fun addLanguage(view: View) {
        val language = etLanguage.text.toString()
        languageViewModel.addLanguage(language)
    }

    override fun itemOnClick(position: Int) {
        languageViewModel.removeLanguage(position)
    }
}
