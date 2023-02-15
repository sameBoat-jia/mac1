package cn.edu.tjut.stud.dao;

import cn.edu.tjut.stud.domain.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface CourseDao extends BaseMapper<Course> {
    /**
     * 培养方案内的课程plan=1
     *
     * @param plan
     */
    @Select("select * from course where plan=#{plan}")
    public List<Course> ShouldSelectCourse(int plan);

    @Select("select * from course where type like '%选修课'")
    public List<Course> SuggestSelectCourse();


}
