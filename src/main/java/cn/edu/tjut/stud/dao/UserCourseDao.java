package cn.edu.tjut.stud.dao;

import cn.edu.tjut.stud.domain.UserCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface UserCourseDao extends BaseMapper<UserCourse>
{
    /**
     * 根据id查询学生课程
     * @param id
     * @return
     */
    @Select("select cno from user_course where id=#{id}")
    public List<Integer> selectCourse(int id);

    /**
     * 学生查成绩
     * @param id
     * @return
     */
    @Select("select cno,score from user_course where id=#{id}")
    public List<Map<Integer,String>> selectCourseAndScore(int id );

    /**
     * 老师查询教的课学生成绩
     * @param cno
     * @return
     */
    @Select("select id,score from user_course where cno=#{cno}")
    public List<Map<Integer,String>> teacherSelectScore(int cno );


    @Delete("delete from user_course where cno=#{cno}")
    void removeCourse(int cno);
}
