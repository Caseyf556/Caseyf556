package com.milestone.four.taskservice;

public class Task {
    
    private String taskID;
    private String taskName;
    private String taskDescription;

    // Constructor error checking
    public Task(String id, String name, String description) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid Name");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }
        this.taskID = id;
        this.taskName = name;
        this.taskDescription = description;
    }
    
    // Getters
    public String GetId() {
        return taskID;
    }
    
    public String GetTaskName() {
        return taskName;
    }
    
    public String GetTaskDescription() {
        return taskDescription;
    }
    
    // Setters error checking
    public void SetTaskName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid Name");
        }
        _taskName = name;
    }
    
    public void setTaskDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }
        _taskDescription = description;
       
    }
}
