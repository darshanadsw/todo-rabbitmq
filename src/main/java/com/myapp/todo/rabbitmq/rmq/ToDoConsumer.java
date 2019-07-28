package com.myapp.todo.rabbitmq.rmq;

import com.myapp.todo.rabbitmq.domain.ToDo;
import com.myapp.todo.rabbitmq.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ToDoConsumer {

    private final ToDoRepository toDoRepository;

    @RabbitListener(queues = "${todo.amqp.queue}")
    public void processToDo(ToDo toDo){
        log.info("Consumer >> {}",toDo);
        log.info("ToDo Created >> " + toDoRepository.save(toDo));
    }

}
