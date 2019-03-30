package com.todo.todoapp.controllers;

import java.util.ArrayList;
import java.util.List;

import com.todo.todoapp.model.Task;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

    List<Task> tasks = new ArrayList<Task>();

    @RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
    public List<Task> getTasks() {
        return tasks;
    }

    @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
    public Task getTask(@RequestParam("id") String id) {
        return tasks.get(Integer.parseInt(id));
    }

    @RequestMapping(value = "/", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
    public Task save(@RequestParam("title") String title, @RequestParam("description") String description) {
        Task task = addTask(title, description);
        return task;
    }

    private Task addTask(String title, String description) {
        Task task = new Task(title, description);
        tasks.add(task);

        return task;
    }

}