package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemListBinding

class CustomAdapter(private var myList: List<User>, var listener: PostInteraction) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemListBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(v)


    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val infUser = myList[position]
        holder.apply {
            binding.userName.text = infUser.name
            binding.timeAgo.text = infUser.timaAgo
            binding.userImage.setImageResource(infUser.userImage)
            binding.photoPost.setImageResource(infUser.postImage)
            binding.userName.setOnClickListener { listener.onClickUsername(infUser.name) }
            binding.timeAgo.setOnClickListener { listener.onClickUsername(infUser.timaAgo) }
            binding.deleteBtn.setOnClickListener { listener.deleteItem(position) }

            //لو عاوز استخدم كليك علي item كامل زي card view استخدم root زي كده
//            binding.root.setOnClickListener {
//                Toast.makeText(
//                    holder.binding.root.context,
//                    "clicked card",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
        }

    }

    fun addData(newList: List<User>) {
        myList = newList
        notifyDataSetChanged()
    }
}