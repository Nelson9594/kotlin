package com.lessonsapp.todo.tasklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lessonsapp.todo.R
import java.util.*


class TaskListFragment : Fragment() {

    private val adapter = TaskListAdapter()
    private var taskList = listOf(
        Task("id1", "title1", "description1"),
        Task("id2", "title2"),
        Task("id3", "title3"),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_task_list, container, false)

        adapter.currentList = taskList
        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter

        val fab = view.findViewById<FloatingActionButton>(R.id.addButton)
        fab.setOnClickListener {
            val newTask =
                Task(id = UUID.randomUUID().toString(), title = "Task ${taskList.size + 1}")
            taskList = taskList + newTask
            refreshAdapter()
        }

//        adapter.onClickDelete = { task ->
//            taskList = taskList - task
//            refreshAdapter()
//        }
    }

    private fun refreshAdapter() {
        adapter.currentList = taskList
        adapter.notifyDataSetChanged()
    }


}