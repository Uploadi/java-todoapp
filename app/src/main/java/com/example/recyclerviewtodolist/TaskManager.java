package com.example.recyclerviewtodolist;

import static java.util.Comparator.comparing;

import android.content.Context;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaskManager {


    public TaskManager(Context context){
        Hawk.init(context).build();
        loadTaskList();
    }

    ArrayList<Task> taskList;

    public void addTask(Task task) {
        task.setChecked(false);
        taskList.add(task);
        saveTasklist();
    }
    public void taskToggle(Task task){
        if(task.getChecked()){
            removeTask(task);
        }else{
            Task updatedTask = taskList.get(taskList.indexOf(task));
            updatedTask.setChecked(true);
            taskList.set(taskList.indexOf(task), updatedTask);
        }
        saveTasklist();
    }
    public void removeTask(Task task){
        taskList.remove(task);
    }

    public ArrayList<Task> getTaskList(){
        return taskList;
    }

    public ArrayList<Task> getDoneTaskList() {
        ArrayList<Task> doneList = new ArrayList<Task>();
        for (Task task : taskList) {
            if (task.getChecked()) {
                doneList.add(task);
            }
        }
        return doneList;
    }

    public ArrayList<Task> getUndoneTaskList() {
        ArrayList<Task> undoneList = new ArrayList<Task>();
        for (Task task : taskList) {
            if (!task.getChecked()) {
                undoneList.add(task);
            }
        }
        return undoneList;
    }

    public int getListCount(ArrayList<Task> ArrayList){
        int listCount =ArrayList.size();
        return listCount;
    }

    public int getTaskCount() {
        return taskList.size();
    }

    protected void saveTasklist(){
        Hawk.put("taskList", taskList);
    }

    protected void loadTaskList(){
        taskList= Hawk.get("taskList", new ArrayList<>());
    }
}