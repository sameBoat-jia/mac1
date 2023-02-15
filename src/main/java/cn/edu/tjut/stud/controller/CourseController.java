package cn.edu.tjut.stud.controller;


import cn.edu.tjut.stud.common.R;
import cn.edu.tjut.stud.domain.Course;
import cn.edu.tjut.stud.service.CourseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;


    @GetMapping
    public R<List<Course>> getAllCourse() {
        List<Course> list = courseService.list();
        return R.success(list);

    }

    @GetMapping("plan/{plan}")
    public R<List<Course>> ShouldSelectCourse(@PathVariable int plan) {
        List<Course> list = courseService.ShouldSelectCourse(plan);
        return R.success(list);

    }
    @PutMapping
    public R<Course> change(@RequestBody Course course) {
        courseService.updateById(course);
        return R.success(course);
    }

    @PostMapping
    public R<Course> addCourse(@RequestBody Course course) {
        boolean save = courseService.save(course);
        return R.success(course);

    }

    @GetMapping("{cno}")
    public R<Course> getById(@PathVariable int cno) {
        Course byId = courseService.getById(cno);

        return R.success(byId);
    }

    @GetMapping("/suggest")
    public R<List<Course>> suggestSlelctCourse() {
        List<Course> list = courseService.SuggestSelectCourse();
        return R.success(list);

    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Course> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return courseService.getPage(currentPage, pageSize);
    }

    @DeleteMapping("{id}")
    public R<String> deleteCourse(@PathVariable int id)
    {
        courseService.removeById(id);
        return R.success("删除成功");
    }
}
