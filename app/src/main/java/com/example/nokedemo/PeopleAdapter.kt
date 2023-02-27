package com.example.nokedemo

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class PeopleAdapter(private val context: Context, private val arrayList: List<User>) :
    ArrayAdapter<User>(
        context,
        R.layout.list_item, arrayList
    ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        val item = getItem(position)
        val imageView: ImageView = view!!.findViewById(R.id.profile_pic)
        val personName: TextView = view.findViewById(R.id.personName)
        val title: TextView = view.findViewById(R.id.title)

        personName.text = item?.Name
        title.text = item?.Title
        Glide.with(context).load(item?.Picture).into(imageView)

        view.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.apply {
                putExtra("user", item)
            }
            context.startActivity(intent)

        }

        return view
    }
}