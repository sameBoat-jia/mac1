package cn.edu.tjut.stud.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserCourseDaoTest {

    @Autowired
    private UserCourseDao userCourseDao;
    @Test
    void selectCourseAndScore()
    {
        userCourseDao.selectCourseAndScore(9);
    }
}