package cn.edu.tjut.stud.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 课程
 *
 * @author jiatongzhou
 * @date 2023/02/25
 */
@Data
public class Course
{
    @TableId
    private int cno;
    private String cname;
    private String type;
    private Double score;
    private String teacher;
    private int plan;
    private int total;
}
