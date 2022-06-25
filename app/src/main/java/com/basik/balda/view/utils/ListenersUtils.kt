package com.basik.balda.view.utils

import android.view.View

fun View.onClick(callback: () -> Unit) {
    setOnClickListener { callback() }
}