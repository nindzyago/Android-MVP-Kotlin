package ru.antipiev.ktemplate.data.adapters

import kotlinx.android.synthetic.main.item_item.view.*
import ru.antipiev.ktemplate.R
import ru.antipiev.ktemplate.data.models.Item
import ru.antipiev.ktemplate.utils.extensions.load

fun compare() = { old: Item, new: Item -> old.id == new.id }

class ItemsAdapter(onClick: (item: Item) -> Unit)
    : BaseRecyclerAdapter<Item>(R.layout.item_item, compare(), onClick) {

    override fun onBind(holder: ViewHolder, item: Item) {
        holder.itemView.sdv_image.load(item.name)
        holder.itemView.tv_text.text = item.name
    }
}



