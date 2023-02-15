package cn.edu.tjut.stud.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value ="user_role")
public class UserRole {

    @TableId
    private int userId;

    private int roleId;

}
