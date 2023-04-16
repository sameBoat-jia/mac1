package cn.edu.tjut.stud.dao;

import cn.edu.tjut.stud.domain.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface CourseDao extends BaseMapper<Course> {
    /**
     * 应该选择课程
     * 培养方案内的课程plan=1
     * @param plan 计划
     * @return {@link List}<{@link Course}>
     */
    @Select("select * from course where plan=#{plan}")
    public List<Course> ShouldSelectCourse(int plan);

    /**
     * 建议选择课程
     *
     * @return {@link List}<{@link Course}>
     */
    @Select("select * from course where type like '%选修课'")
    public List<Course> SuggestSelectCourse();

    @Select("select*from course where cno=#{cno}")
    public Course selectMyCourse(int cno);

}
