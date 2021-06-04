package com.example.vmdirectory.ui.room

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vmdirectory.R
import com.example.vmdirectory.data.model.Room
import com.example.vmdirectory.databinding.ItemRoomBinding

class RoomAdapter(private val listener: RoomItemListener) : RecyclerView.Adapter<RoomViewHolder>() {

    interface RoomItemListener {
        fun onClickedItem(roomId: Int)
    }

    private val items = ArrayList<Room>()

    fun setItems(items: ArrayList<Room>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val binding: ItemRoomBinding = ItemRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) = holder.bind(items[position])
}

class RoomViewHolder(private val itemBinding: ItemRoomBinding, private val listener: RoomAdapter.RoomItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var room: Room

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Room) {
        this.room = item
        itemBinding.name.text = item.name
        itemBinding.maxOccupancy.text = """ ${item.max_occupancy}"""
        if(item.is_occupied) {
            itemBinding.roomImg.setImageResource(R.drawable.ic_baseline_no_meeting_room_24)
        }
        else
        {
            itemBinding.roomImg.setImageResource(R.drawable.ic_baseline_meeting_room_24)
        }

    }

    override fun onClick(v: View?) {
        listener.onClickedItem(room.id)
    }
}
