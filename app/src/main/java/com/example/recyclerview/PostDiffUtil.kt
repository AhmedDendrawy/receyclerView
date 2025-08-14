package com.example.recyclerview

import androidx.recyclerview.widget.DiffUtil

class PostDiffUtil(val mOldList: List<User>, val mNewList: List<User>) : DiffUtil.Callback() {
    override fun getOldListSize() = mOldList.size

    override fun getNewListSize() = mNewList.size

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return (
                mOldList[oldItemPosition].name == mNewList[newItemPosition].name &&
                        mOldList[oldItemPosition].postImage == mNewList[newItemPosition].postImage
                )
    }

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return true
    }
}