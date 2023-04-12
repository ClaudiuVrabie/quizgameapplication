package com.internship.QuizGame.model.dto;

import com.internship.QuizGame.model.Player;

public class PlayerDto {
    private Integer id;
    private String name;
    private Integer age;



    public PlayerDto (Player player){

        this.id = player.getId();
        this.name = player.getName();
        this.age = player.getAge();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
