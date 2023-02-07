package cn.edu.tjut.stud.service.impl;


import cn.edu.tjut.stud.dao.UserDao;
import cn.edu.tjut.stud.domain.User;
import cn.edu.tjut.stud.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService
{
}
