package com.example.exercise_recycleview.language.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_recycleview.R

/**
 * Created by Maulana Ibrahim on 15/August/2020
 * Email maulibrahim19@gmail.com
 */
class LanguageRecycleAdapter(private val languageList: MutableList<String>) :
    RecyclerView.Adapter<LanguageViewHolder>() {

    lateinit var listener: ILanguageRecycleListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.language_item_layout, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.orderNumber.text = position.toString()
        holder.language.text = languageList[position]
        holder.btnDelete.setOnClickListener {
            listener.itemOnClick(position)
        }
    }
}