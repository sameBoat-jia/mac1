package cn.edu.tjut.stud.service.impl;


import cn.edu.tjut.stud.dao.CourseDao;
import cn.edu.tjut.stud.dao.UserCourseDao;
import cn.edu.tjut.stud.domain.Course;
import cn.edu.tjut.stud.domain.UserCourse;
import cn.edu.tjut.stud.service.CourseService;
import cn.edu.tjut.stud.service.UserCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.aop.framework.AopContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserCourseServiceImpl extends ServiceImpl<UserCourseDao, UserCourse> implements UserCourseService {

    @Resource
    private UserCourseService userCourseService;

    @Resource
    private CourseService courseService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UserCourseDao userCourseDao;

    @Resource
    private CourseDao courseDao;

    @Resource
    private RedissonClient redissonClient;

    @Override
    public void proxy(UserCourse userCourse) {
        int cno = userCourse.getCno();
//        synchronized (String.valueOf(cno).intern()) {
        int id = userCourse.getId();
//        SimpleRedisLock lock = new SimpleRedisLock("order:" + id, stringRedisTemplate);
        RLock lock = redissonClient.getLock("lock:order:" + id);
        boolean isLock = lock.tryLock();
        if (!isLock)
        {
            //获取锁不成功
            return;
        }
        try {
            UserCourseService proxy = (UserCourseService) AopContext.currentProxy();
            proxy.addCourse(userCourse);
        } finally {
            lock.unlock();
        }
//        }
    }

    @Override
    public List<Course> selectCourse(int id) {
        List<Integer> list = userCourseDao.selectCourse(id);
        List<Course> userCourses = courseDao.selectBatchIds(list);
        System.out.println("userCourses = " + userCourses);
        return userCourses;
    }


    @Override
    @Transactional
    public void addCourse(UserCourse userCourse) {

        int cno = userCourse.getCno();
        synchronized (String.valueOf(cno).intern()) {
            Course course = courseService.selectMyCourse(cno);
            if (course.getTotal() < 1) {
                return;
            }
            int count = query().eq("cno", cno).eq("id", userCourse.getId()).count();
            if (count > 0) {
                return;
            }
            boolean flag = courseService.update().setSql("total=total-1")
                    .eq("cno", course.getCno()).gt("total", 0)
                    .update();

            if (!flag) {
                return;
            }
            userCourseService.save(userCourse);
        }
    }
}
