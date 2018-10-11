package com.newsapp.ui.main.view

import com.newsapp.R
import com.newsapp.domain.entities.Article
import com.newsapp.extensions.toHtml
import com.squareup.picasso.Picasso
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.view_article_list_item.view.*

class ArticleListItem(
        val data: Article) : Item<ViewHolder>() {

    override fun getLayout() = R.layout.view_article_list_item

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.apply {
            title.text = data.title
            timestamp.text = data.created.formatted
            body.text = data.teaser_html.toHtml()

            Picasso.get()
                    .load(data.image.medium)
                    .placeholder(R.color.colorImagePlaceholder)
                    .into(thumb)
        }
    }
}
