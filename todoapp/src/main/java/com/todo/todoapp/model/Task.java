package com.todo.todoapp.model;

public class Task {

    private static final int _1 = 1;
    private static final int _1000 = 100000;
    public Integer id;
    public String title;
    public String description;

    public Task(String title, String description) {
        this.id = (int) (Math.random() * _1000) + _1;
        this.title = title;
        this.description = description;
    }
}