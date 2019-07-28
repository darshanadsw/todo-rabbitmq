package com.myapp.todo.rabbitmq.rmq;

import com.myapp.todo.rabbitmq.domain.ToDo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ToDoProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendTo(String queue, ToDo toDo){
        rabbitTemplate.convertAndSend(queue,toDo);
        log.info("Producer >> Message sent.");
    }
}
