package cn.edu.tjut.stud.dao;


import cn.edu.tjut.stud.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseDaoTestCase
{
    @Autowired
    private CourseDao courseDao;

    /**
     * 根据课称号查寻课程
     */
    @Test
    void testGetByCno()
    {
        Course course = courseDao.selectById(2267123);
        System.out.println(course);
    }

    /**
     * 测试查询全部
     */
    @Test
    void testGetAll()
    {
        List<Course> courses = courseDao.selectList(null);
        System.out.println(courses);
    }

    /**
     * 插入数据测试
     */
    @Test
    void testInsertCourse()
    {
        Course course = new Course();
        course.setCno(2262023);
        course.setCname("计算机网络原理");
        course.setType("学科基础课");
        course.setScore(3);
        course.setDescription("aaaaaaaa");
        course.setTeacher("杨文军");
        courseDao.insert(course);
        System.out.println(course);
    }

    /**
     * 根据课称号删除课程
     */
    @Test
    void testDeleteByCno()
    {
        courseDao.deleteById(2262023);
        System.out.println(courseDao.selectList(null));
    }

    /**
     * 测试修改课程信息
     */

    @Test
    void testupdate()
    {
        Course course = new Course();
        course.setCno(2262023);
        course.setCname("计算机网络原理");
        course.setType("学科基础课");
        course.setScore(2.5);
        course.setDescription("bbbbbbbbbbbbbbb");
        course.setTeacher("杨文军");
        System.out.println(courseDao.selectList(null));
        System.out.println("---------------------------");
        courseDao.updateById(course);
        System.out.println(courseDao.selectList(null));
    }
}
