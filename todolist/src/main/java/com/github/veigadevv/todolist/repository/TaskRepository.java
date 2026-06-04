package com.github.veigadevv.todolist.repository;

import com.github.veigadevv.todolist.model.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TaskRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Task save(Task task) {
        entityManager.persist(task);
        return task;
    }

    public Task findById(Long id) {
        return entityManager.find(Task.class, id);
    }

    public List<Task> findAll() {
        return entityManager.createQuery("SELECT t FROM Task t", Task.class)
                .getResultList();
    }

    @Transactional
    public Task update(Task task) {
        return entityManager.merge(task);
    }

    @Transactional
    public void delete(Long id) {
        Task task = findById(id);
        if (task != null) {
            entityManager.remove(task);
        }
    }
}