package com.example.recyclerviewtodolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button taskButton;
    TaskManager taskManager;
    RecyclerView Recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskManager = new TaskManager(this);

        initviews();

        initClickListeners();
    }

    protected void initviews(){

        editText = findViewById(R.id.source);
        taskButton = findViewById(R.id.button);
        Recycler = findViewById(R.id.task_list);
        Recycler.setLayoutManager(new LinearLayoutManager(this));
        Recycler.setAdapter(new TaskListAdapter(taskManager));
    }

    protected void initClickListeners(){
        taskButton.setOnClickListener(view -> onTaskButtonClick());
    }
    protected void onTaskButtonClick(){
        String nameOfNewTask = editText.getText().toString();
        if (nameOfNewTask.length() > 1){

            Task task = new Task();
            task.setName(nameOfNewTask);
            taskManager.addTask(task);
            editText.setText("");
            Recycler.getAdapter().notifyDataSetChanged();
        }   else{

        }

    }
}