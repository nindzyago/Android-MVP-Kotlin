package ru.antipiev.ktemplate.data.adapters

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.sdk25.listeners.onClick
import org.jetbrains.anko.sdk25.listeners.onLongClick
import ru.antipiev.ktemplate.utils.extensions.inflate

fun <T> RecyclerView.Adapter<*>.autoNotify(oldList: List<T>, newList: List<T>, compare: (T, T) -> Boolean) {
    val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            compare(oldList[oldItemPosition], newList[newItemPosition])

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size
    })
    diff.dispatchUpdatesTo(this)
}

abstract class BaseRecyclerAdapter<T>(private val layout: Int,
                                      private val compare: (T, T) -> Boolean,
                                      private val onClick: (item: T) -> Unit = {},
                                      private val onLongClick: (item: T) -> Boolean = { false })
    : RecyclerView.Adapter<BaseRecyclerAdapter<T>.ViewHolder>() {

    var items : List<T> = ArrayList()
        set(value) {
            val oldValue = field
            field = value
            autoNotify(oldValue, value, compare)
        }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!)

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = parent.inflate(layout)
        val item = items[position]
        view.onClick { onClick.invoke(item) }
        view.onLongClick { onLongClick.invoke(item) }
        return ViewHolder(view)
    }

    abstract fun onBind(holder: ViewHolder, item: T)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onBind(holder, items[position])
    }

}


