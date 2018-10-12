package com.newsapp.ui.main.view

import com.newsapp.R
import com.newsapp.extensions.toHtml
import com.newsapp.ui.main.domain.Article
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
            timestamp.text = data.created
            body.text = data.teaserHtml.toHtml()

            if (data.imageMedium.isNotBlank()) {
                Picasso.get()
                        .load(data.imageMedium)
                        .placeholder(R.color.white)
                        .into(thumb)
            }
        }
    }
}
