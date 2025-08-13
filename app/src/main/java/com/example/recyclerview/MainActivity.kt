package com.example.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PostInteraction {
    lateinit var adapter: CustomAdapter
    lateinit var binding: ActivityMainBinding
    val myArray = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mRecyclerView: RecyclerView = findViewById(R.id.mRecyclerView)
        myArray.add(User("Adam Dendrawy Sleem", "50 min ago", R.drawable.per2, R.drawable.post2))
        myArray.add(User("Ahmed Sleem Ali", "5 min ago", R.drawable.per3, R.drawable.post3))
        myArray.add(User("Mohamed Ahmed Sleem", "6 min ago", R.drawable.per4, R.drawable.post4))
        myArray.add(User("Arwa Dendrawy Sleem", "40 min ago", R.drawable.per5, R.drawable.post5))
        myArray.add(User("Youssef mohamed Sleem", "36 min ago", R.drawable.per6, R.drawable.post6))
        myArray.add(User("Radwa adel ahmed ", "11 min ago", R.drawable.per7, R.drawable.post7))
        myArray.add(User("Mazen saad ahmed", "10 min ago", R.drawable.per8, R.drawable.post9))
        myArray.add(User("Sara ali ahmed", "18 min ago", R.drawable.per9, R.drawable.post9))
        myArray.add(User("Ahmed sleem khaled", "18 min ago", R.drawable.per2, R.drawable.post1))
       //mRecyclerView.adapter = CustomAdapter(myArray, this)
        //val customAdapter=CustomAdapter(myArray)
        adapter = CustomAdapter(myArray, this)
        binding.mRecyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            val newPost= User(
                name = "Maro",
                timaAgo = "40min",
                postImage = R.drawable.per2,
                userImage = R.drawable.per2
            )
            myArray.add(newPost)
            adapter.notifyItemInserted(myArray.size-1)
            binding.mRecyclerView.scrollToPosition(myArray.size-1)
        }

    }
    override fun onClickItem(user: User) {
        TODO("Not yet implemented")
    }

    override fun onClickUsername(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_LONG).show()
    }

    override fun deleteItem(index: Int) {
        myArray.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

}