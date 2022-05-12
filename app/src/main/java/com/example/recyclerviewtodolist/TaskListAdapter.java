
package com.example.recyclerviewtodolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class TaskListAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    TaskManager taskManager;


    public TaskListAdapter(TaskManager taskManager){
        this.taskManager = taskManager;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TaskViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_item_with_subtitle, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder taskViewHolder, int i) {
        Task task = new Task();
        if(i < taskManager.getUndoneTaskList().size()){
            task = taskManager.getUndoneTaskList().get(i);
        }else{
            task = taskManager.getDoneTaskList().get(i-taskManager.getUndoneTaskList().size());
        }

        if(isBetweenLists(taskManager.getDoneTaskList(), taskManager.getTaskList(), i)){
            taskViewHolder.textView.setVisibility(View.VISIBLE);
        }else{
            taskViewHolder.textView.setVisibility(View.GONE);
        }

        taskViewHolder.checkbox.setText(task.getName());
        taskViewHolder.checkbox.setChecked(task.getChecked());
        Task finalTask = task;
        taskViewHolder.checkbox.setOnClickListener(view -> onListButtonClick(finalTask,i));
    }


    public void onListButtonClick(Task task, int i){
        taskManager.taskToggle(task);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return taskManager.getTaskCount();

    }

    public static String boolToString(boolean boolValue){
        String boolName;
        if (boolValue){
            boolName = "true";
        }else {
            boolName = "false";
        }

    return boolName;
    }

    public Boolean isBetweenLists(ArrayList<Task> DoneList, ArrayList<Task> Tasklist, int i){
        if(DoneList.size() != 0 && i == Tasklist.size() - DoneList.size() - 1){
            return true;
        }else return false;
    }

}

