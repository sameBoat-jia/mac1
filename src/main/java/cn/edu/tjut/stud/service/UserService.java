package cn.edu.tjut.stud.service;

import cn.edu.tjut.stud.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User>
{
    public List<User> selectByIdWithRole(int id );
}
