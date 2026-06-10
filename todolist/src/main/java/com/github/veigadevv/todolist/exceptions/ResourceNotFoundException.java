package com.github.veigadevv.todolist.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Recurso não encontrado. ID: " + id);
    }
}
