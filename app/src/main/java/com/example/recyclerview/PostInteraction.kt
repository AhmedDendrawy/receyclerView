package com.example.recyclerview

interface PostInteraction {
    fun onClickItem(user: User)
    fun onClickUsername(name: String)
    fun deleteItem(index: Int)
}