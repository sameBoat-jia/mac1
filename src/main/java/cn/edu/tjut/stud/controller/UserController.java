package cn.edu.tjut.stud.controller;


import cn.edu.tjut.stud.common.R;
import cn.edu.tjut.stud.domain.User;
import cn.edu.tjut.stud.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/aaa")
    public String a()
    {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        return "aaaaaaaaaaaaaaaaaaa";
    }
    @PostMapping("/login")
    public R<User> login(HttpServletRequest request, @RequestBody User user) {
        String password = user.getPassword();//拿到页面发来的密码，存入password
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());//工具类进行md5加密

        //查数据库
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername, user.getUsername());//查用户

        User user1 = userService.getOne(userLambdaQueryWrapper);

        if (user1 == null) {
            return R.error("登录失败");
        }
        if (!user1.getPassword().equals(md5Password)) {
            return R.error("密码不正确，请重试");
        }

        //登录成功
        request.getSession().setAttribute("user", user1.getId());
        return R.success(user1);
    }
}
