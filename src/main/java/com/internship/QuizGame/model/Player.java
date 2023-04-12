package com.internship.QuizGame.model;

import com.internship.QuizGame.model.dto.CreatePlayerDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="players")
@SuperBuilder
@Data
@RequiredArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Player extends User {

    private String name;
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
