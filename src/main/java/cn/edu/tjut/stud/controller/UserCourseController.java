package cn.edu.tjut.stud.controller;


import cn.edu.tjut.stud.common.R;
import cn.edu.tjut.stud.domain.Course;
import cn.edu.tjut.stud.domain.UserCourse;
import cn.edu.tjut.stud.service.CourseService;
import cn.edu.tjut.stud.service.UserCourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/select")
public class UserCourseController
{
    @Resource
    private UserCourseService userCourseService;

    @Resource
    private CourseService courseService;

    @PostMapping
    public R<UserCourse> addCourse(@RequestBody UserCourse userCourse) {
//        boolean save = userCourseService.save(userCourse);
//        userCourseService.addCourse(userCourse);
        userCourseService.proxy(userCourse);
        return R.success(userCourse);
    }

    @GetMapping("{id}")
    public List<Course> selectCourses(@PathVariable int id)
    {
        List<Course> courses = userCourseService.selectCourse(id);
        return courses;
    }

    @DeleteMapping("{cno}")
    public void delete(@PathVariable int cno)
    {
        userCourseService.removeCourse(cno);
    }
}
