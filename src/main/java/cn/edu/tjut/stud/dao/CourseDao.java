package cn.edu.tjut.stud.dao;


import cn.edu.tjut.stud.domain.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseDao extends BaseMapper<Course>
{
}
