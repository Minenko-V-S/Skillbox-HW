package main.service;


import main.model.Task;
import main.repositories.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements ToDoRep {

    private final ToDoRepository todoRepository;

    public TodoService(ToDoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Task> getTasks() {
        return todoRepository.findAll();
    }
    @Override
    public void saveOrUpdate(Task task) {
        todoRepository.save(task);
    }
    @Override
    public Task getById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }
@Override
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
