package cn.edu.tjut.stud.domain;


import lombok.Data;

@Data
public class Course
{
    private Long id;
    private String cname;
    private String type;
    private Double score;
    private String teacher;
}
