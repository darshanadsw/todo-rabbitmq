package com.myapp.todo.rabbitmq.config;

import com.myapp.todo.rabbitmq.domain.ToDo;
import com.myapp.todo.rabbitmq.rmq.ToDoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EnableScheduling
@Configuration
@RequiredArgsConstructor
public class ToDoSender {

    private final ToDoProducer producer;

    @Value("${todo.amqp.queue}")
    private String destination;


    @Bean
    public CommandLineRunner sendToDos(@Value("${todo.amqp.queue}") String destination, ToDoProducer producer){
        return args -> producer.sendTo(destination,new ToDo("Spring boot is awesome !!! " +
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
    }

    @Scheduled(fixedRate = 1000L)
    private void sendToDos(){

        producer.sendTo(destination,new ToDo("Spring boot is awesome !!! " +
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));

    }
}
