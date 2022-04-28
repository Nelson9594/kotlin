package com.lessonsapp.todo.tasklist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class TaskListAdapter : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    var currentList: List<String> = emptyList()

    // on utilise `inner` ici afin d'avoir accès aux propriétés de l'adapter directement
        inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(taskTitle: String) {
            // on affichera les données ici
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        TODO("Not yet implemented")
    }
}