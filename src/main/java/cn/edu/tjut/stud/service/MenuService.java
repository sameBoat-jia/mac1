package cn.edu.tjut.stud.service;

import cn.edu.tjut.stud.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author jiatongzhou
* @description 针对表【menu】的数据库操作Service
* @createDate 2023-02-12 12:10:29
*/
public interface MenuService extends IService<Menu> {



    public List<Menu> findAll() ;

    public List<Menu> findByUser(String username) ;
}
