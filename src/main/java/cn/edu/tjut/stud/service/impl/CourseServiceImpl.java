package cn.edu.tjut.stud.service.impl;

import cn.edu.tjut.stud.dao.CourseDao;
import cn.edu.tjut.stud.domain.Course;
import cn.edu.tjut.stud.service.CourseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl extends ServiceImpl<CourseDao, Course> implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public IPage<Course> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        courseDao.selectPage(page, null);
        return page;
    }

    public List<Course> ShouldSelectCourse(int plan) {
        return courseDao.ShouldSelectCourse(plan);

    }

    @Override
    public List<Course> SuggestSelectCourse() {

        return courseDao.SuggestSelectCourse();
    }
}
