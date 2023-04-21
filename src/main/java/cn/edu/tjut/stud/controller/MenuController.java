package cn.edu.tjut.stud.controller;


import cn.edu.tjut.stud.domain.Menu;
import cn.edu.tjut.stud.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单控制器
 *
 * @author jiatongzhou
 * @date 2023/02/25
 */
@Slf4j
@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

//    @GetMapping
//    public R<Menu> findAll() {
//        Menu menu = new Menu();
//        menu.
//        return R.success(menu)
////        return R.success(menuService.findAll());
//    }

    /**
     * 找到
     *
     * @param username 用户名
     * @return {@link List}<{@link Menu}>
     *///    @GetMapping("/{username}")
//    public R<Menu> findBy(@PathVariable String username) {
//        Menu menu = new Menu();
//
////        menu.setId(menuService.findByUser(username));
//        return R.success(menu);
//    }
    @GetMapping("/{username}")
    public List<Menu> findBy(@PathVariable String username)
    {
        return (menuService.findByUser(username));
    }

}
