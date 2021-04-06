package main.service;


import main.model.Task;

import java.util.List;

public interface ToDoRep {
    public List<Task> getTasks();
    public void saveOrUpdate(Task task);
    public Task getById(Long id);
    public void deleteById(Long id);
}
