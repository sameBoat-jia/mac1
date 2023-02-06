package cn.edu.tjut.stud;

import cn.edu.tjut.stud.dao.CourseDao;
import cn.edu.tjut.stud.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LabradorApplicationTests {


    @Autowired
    private CourseDao courseDao;

    @Test
    void contextLoads() {
        Course course = new Course();
        course.setCno(2267123);
        course.setCname("数字图像处理");
        course.setType("必修");
        course.setDescription("aaaaaaaaaaaaaaaaaaaaa");
        courseDao.insert(course);
    }

}
