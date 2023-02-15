package cn.edu.tjut.stud.service.impl;

import cn.edu.tjut.stud.dao.RoleDao;
import cn.edu.tjut.stud.domain.UserRole;
import cn.edu.tjut.stud.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, UserRole>implements RoleService
{
}
