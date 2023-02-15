package cn.edu.tjut.stud.service.impl;


import cn.edu.tjut.stud.dao.UserDao;
import cn.edu.tjut.stud.domain.User;
import cn.edu.tjut.stud.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService
{
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> selectByIdWithRole(int id) {
        return userDao.selectByIdWithRole(id);
    }
}
