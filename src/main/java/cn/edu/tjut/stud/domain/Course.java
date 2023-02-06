package cn.edu.tjut.stud.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Course
{
    @TableId
    private Integer cno;
    private String type;
    private String cname;
    private String description;
    private String teacher;
    private double  score;//学分

}
