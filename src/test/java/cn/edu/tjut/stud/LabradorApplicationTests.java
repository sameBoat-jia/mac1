package cn.edu.tjut.stud;

import cn.edu.tjut.stud.dao.CourseDao;
import cn.edu.tjut.stud.dao.UserCourseDao;
import cn.edu.tjut.stud.dao.UserDao;
import cn.edu.tjut.stud.domain.UserRole;
import cn.edu.tjut.stud.service.RoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LabradorApplicationTests {


    @Autowired
    private CourseDao courseDao;

    @Autowired
    private UserCourseDao userCourseDao;
    @Test
    void selectCourseAndScore()
    {
        userCourseDao.selectCourseAndScore(9);
    }
    /**
     * 分页功能
     */
    @Test
    void testPage()
    {
        IPage page=new Page(1,3);
        courseDao.selectPage(page,null) ;
    }


    /**
     * 测试根据角色查询
     * 老师的页面显示老师
     * 学生的页面显示学生
     * @param userDao
     */
    @Test
    void testselectByIdWithRole(@Autowired UserDao userDao)
    {
        System.err.println(userDao.selectByIdWithRole(3));
        System.err.println(userDao.selectByIdWithRole(2));
        System.err.println(userDao.selectByIdWithRole(1));
    }


    @Autowired
    private RoleService roleService;
    @Test
    void aa()
    {
        List<UserRole> userRoles = roleService.list();
        System.out.println(userRoles);
    }

    @Test
    void aaa()
    {
        UserRole userRole = new UserRole();
        roleService.updateById(userRole );
    }
}
