package cn.edu.tjut.stud.domain;


import lombok.Data;

@Data
public class User
{
    private int id;
    private String username;
    private String password;
    private String sex;
    private String description;
    private String name;
}
