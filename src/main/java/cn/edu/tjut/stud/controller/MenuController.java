package cn.edu.tjut.stud.controller;


import cn.edu.tjut.stud.common.R;
import cn.edu.tjut.stud.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/api/menu")
    public R findAll() {
        return R.success(menuService.findAll());
    }

    @GetMapping("/api/menu/{username}")
    public R findBy(@PathVariable String username) {
        return R.success(menuService.findByUser(username));
    }

}
