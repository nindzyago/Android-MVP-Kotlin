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

fun View.hide() {
    if (visibility == View.VISIBLE) {
        visibility = View.GONE
    }
}

fun View.invisible() {
    if (visibility == View.VISIBLE) {
        visibility = View.INVISIBLE
    }
}

fun View.show() {
    if (visibility == View.GONE || visibility == View.INVISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.visibleIf(visible: Boolean?) {
    if (visible!=null && visible) show() else hide()
}

fun View.invisibleIf(invisible: Boolean?) {
    if (invisible!=null && invisible) invisible() else show()
}

fun View.toggleSelected() {
    isSelected = !isSelected
}
