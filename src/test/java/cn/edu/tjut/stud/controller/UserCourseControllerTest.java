package cn.edu.tjut.stud.controller;

import cn.edu.tjut.stud.service.UserCourseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserCourseControllerTest
{
    @Resource
   private UserCourseService userCourseService;

    @Test
    void aVoid()
    {
        userCourseService.removeCourse(7);
    }
}