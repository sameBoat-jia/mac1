package cn.edu.tjut.stud.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName menu
 */
@TableName(value ="menu")
@Data
public class Menu  {
    /**
     * 
     */
    @TableId
    private int id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String path;

    /**
     * 
     */
    private String component;


}