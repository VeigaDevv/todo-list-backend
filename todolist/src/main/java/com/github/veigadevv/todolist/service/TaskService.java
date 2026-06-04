package com.github.veigadevv.todolist.service;

import com.github.veigadevv.todolist.model.Task;
import com.github.veigadevv.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        Task task = taskRepository.findById(id);
        if (task == null) {
            throw new RuntimeException("Tarefa não encontrada com o ID: " + id);
        }
        return task;
    }

    public Task update(Long id, Task taskDetails) {
        Task existingTask = getById(id);

        existingTask.setTitle(taskDetails.getTitle());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setCompleted(taskDetails.isCompleted());

        return taskRepository.update(existingTask);
    }

    public void delete(Long id) {
        Task task = getById(id);
        taskRepository.delete(task.getId());
    }
}