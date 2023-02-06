package cn.edu.tjut.stud.controller;


import cn.edu.tjut.stud.common.R;
import cn.edu.tjut.stud.domain.Course;
import cn.edu.tjut.stud.domain.User;
import cn.edu.tjut.stud.service.CourseService;
import cn.edu.tjut.stud.service.UserService;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;



    /**
     * 查询单个
     * @param cno
     * @return
     */
    @GetMapping("/{cno}")
    public Course selectOne(@PathVariable Integer cno)
    {
        log.info("查询中....................");
        return courseService.getById(cno);
    }

    /**
     * 查询全部课程
     * @return
     */
    @GetMapping
    public List<Course> selectAll()
    {
        List<Course> list = courseService.list();
        return list;
    }

//    @PostMapping
//    public void insertCourse(@RequestBody Course course)
//    {
//        courseService.update();
//    }
}
