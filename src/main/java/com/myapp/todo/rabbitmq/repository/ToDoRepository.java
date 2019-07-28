package com.myapp.todo.rabbitmq.repository;

import com.myapp.todo.rabbitmq.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo,String> {
}
