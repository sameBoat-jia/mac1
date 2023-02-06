package cn.edu.tjut.stud.service.impl;

import cn.edu.tjut.stud.dao.CourseDao;
import cn.edu.tjut.stud.domain.Course;
import cn.edu.tjut.stud.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl extends ServiceImpl<CourseDao, Course>implements CourseService
{

}
