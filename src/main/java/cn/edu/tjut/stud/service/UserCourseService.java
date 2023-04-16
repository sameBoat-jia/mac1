package cn.edu.tjut.stud.service;

import cn.edu.tjut.stud.domain.Course;
import cn.edu.tjut.stud.domain.UserCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserCourseService extends IService<UserCourse>
{
    void addCourse(UserCourse userCourse);

    void proxy(UserCourse userCourse);

    List<Course> selectCourse(int id);

//    List<UserCourse>   allCourse(int id);
}
