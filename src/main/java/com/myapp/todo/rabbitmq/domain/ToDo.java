package com.myapp.todo.rabbitmq.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotNull
    @NotBlank
    private String description;

    @Column(insertable = true,updatable = false)
    private LocalDateTime created;

    private LocalDateTime modified;

    @PrePersist
    void onCreated(){
        setCreated(LocalDateTime.now());
    }

    @PreUpdate
    void onUpdate(){
        setModified(LocalDateTime.now());
    }

    public ToDo(String description){
        this.description = description;
    }

}
