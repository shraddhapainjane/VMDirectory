package com.example.vmdirectory.ui.people

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.vmdirectory.data.model.People
import com.example.vmdirectory.databinding.ItemPeopleBinding

class PeopleAdapter(private val listener: PeopleItemListener) :
    RecyclerView.Adapter<PeopleViewHolder>() {

    private val items = ArrayList<People>()

    fun setItems(items: ArrayList<People>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding: ItemPeopleBinding =
            ItemPeopleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) =
        holder.bind(items[position])

    interface PeopleItemListener {
        fun onClickedItem(peopleId: Int)
    }
}

class PeopleViewHolder(
    private val itemBinding: ItemPeopleBinding,
    private val listener: PeopleAdapter.PeopleItemListener
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var people: People

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: People) {
        this.people = item
        itemBinding.firstname.text = """${item.firstName}  ${item.lastName}"""
        itemBinding.emailId.text = """${item.email}"""
        itemBinding.jobDesc.text = """${item.jobTitle}"""
        Glide.with(itemBinding.root)
            .load(item.avatar)
            .transform(CircleCrop())
            .into(itemBinding.avatarImg)
    }

    override fun onClick(v: View?) {
        listener.onClickedItem(people.id)
    }
}
