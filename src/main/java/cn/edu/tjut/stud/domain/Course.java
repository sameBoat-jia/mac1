package cn.edu.tjut.stud.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Course
{
    @TableId
    private int cno;
    private String cname;
    private String type;
    private Double score;
    private String teacher;
}
