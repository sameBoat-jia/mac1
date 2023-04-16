package cn.edu.tjut.stud.service;


import cn.edu.tjut.stud.domain.Course;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CourseService extends IService<Course>
{
    IPage<Course> getPage(int currentPage, int pageSize);
    public List<Course> ShouldSelectCourse(int plan);
    public List<Course> SuggestSelectCourse();

    public Course selectMyCourse(int cno);
}
