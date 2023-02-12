package cn.edu.tjut.stud.service.impl;

import cn.edu.tjut.stud.dao.MenuDao;
import cn.edu.tjut.stud.domain.Menu;
import cn.edu.tjut.stud.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author jiatongzhou
* @description 针对表【menu】的数据库操作Service实现
* @createDate 2023-02-12 12:10:29
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {
    @Autowired
    private MenuDao menuDao;

    public List<Menu> findAll() {
        return menuDao.findAll();
    }

    public List<Menu> findByUser(String username) {
        return menuDao.findByUser(username);
    }
}




