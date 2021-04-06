package main.controllers;


import main.model.Task;
import main.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class ToDoController {

    private final TodoService todoService;

  @Autowired
    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public String getListOfTasks(Model model){
        List<Task> tasks = todoService.getTasks();
        model.addAttribute("task", tasks);
        return "index";
    }

    @GetMapping("/add")
    public String showAddTaskForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "edit";
    }

    @PostMapping("/edit")
    public String addTask(@ModelAttribute(value = "task") Task task) {
        todoService.saveOrUpdate(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditTaskForm(Model model, @PathVariable(value = "id") Long id) {
        Task task = todoService.getById(id);
        model.addAttribute("task", task);
        return "edit";
    }

    @GetMapping("/show/{id}")
    public String showOneTask(Model model, @PathVariable(value = "id") Long id) {
        Task task = todoService.getById(id);
        model.addAttribute("task", task);
        return "task-page";
    }

    @GetMapping("/delete/{id}")
    public String deleteTaskById(@PathVariable(value = "id") Long id) {
        todoService.deleteById(id);
        return "redirect:/tasks";
    }
}