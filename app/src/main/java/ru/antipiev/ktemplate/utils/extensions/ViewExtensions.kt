package ru.antipiev.ktemplate.utils.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.view.SimpleDraweeView

fun ViewGroup.inflate(layout: Int): View =
        LayoutInflater.from(context).inflate(layout, this, false)

fun SimpleDraweeView.load(url: String) {
    setImageURI(url)
}
