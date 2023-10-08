package com.example.javatry;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setId(int id){}


}
