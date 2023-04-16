package cn.edu.tjut.stud.dao;

import cn.edu.tjut.stud.domain.Course;
import cn.edu.tjut.stud.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserDao extends BaseMapper<User>
{
    /**
     * 查询出所有学生，或老师
     * 如果是更改学生信息就传入2
     * 如果是更改老师信息就传入3
     * @param id
     * @return
     */
    @Select("SELECT * FROM USER WHERE id in\n" +
            "(\n" +
            "    SELECT user_id FROM user_role\n" +
            "    where role_id=#{id}\n" +
            "                             );")
    public List<User> selectByIdWithRole(int id );


    @Insert("insert into user (id,username,password,sex,description,name ) " +
            "values (#{id},#{username},#{password},#{sex},#{description},#{name});")
    public List<Course> insertUser(User user);

}
