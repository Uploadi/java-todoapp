package com.example.recyclerviewtodolist;

public class Task {
    String name;
    Boolean checked;

    //setter for the variable name
    public void setName(String name) {
        this.name = name;
    }

    //getter for the variable name
    public String getName(){
        return name;
    }

    //the same thing for the variable checked
    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
