package com.example.exercise_recycleview.language.adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_recycleview.R

/**
 * Created by Maulana Ibrahim on 15/August/2020
 * Email maulibrahim19@gmail.com
 */
class LanguageViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val orderNumber: TextView = v.findViewById(R.id.tvOrderNumber)
    val language: TextView = v.findViewById(R.id.tvLanguage)
    val btnDelete:Button = v.findViewById(R.id.btnDelete)
}