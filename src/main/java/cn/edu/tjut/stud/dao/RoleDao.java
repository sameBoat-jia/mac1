package cn.edu.tjut.stud.dao;

import cn.edu.tjut.stud.domain.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RoleDao extends BaseMapper<UserRole>
{
}
