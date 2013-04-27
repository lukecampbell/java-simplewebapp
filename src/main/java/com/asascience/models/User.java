package com.asascience.models;

public class User {
    private long id;
    private String name;
    private int age;

    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
}

