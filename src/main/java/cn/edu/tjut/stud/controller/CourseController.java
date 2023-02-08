package cn.edu.tjut.stud.controller;


import cn.edu.tjut.stud.domain.Course;
import cn.edu.tjut.stud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController
{
    @Autowired
    private CourseService courseService;


    @GetMapping
    public List<Course> getAllCourse()
    {
        List<Course> list = courseService.list();
        return list;

    }
    @GetMapping("{cno}")
    public Course getById(@PathVariable Long cno)
    {
        return courseService.getById(cno);
    }
}
