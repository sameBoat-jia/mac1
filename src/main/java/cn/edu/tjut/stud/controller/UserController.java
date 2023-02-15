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
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户登录
     *
     * @param request
     * @param user
     * @return
     */
    @PostMapping("/login")
    public R<User> login(HttpServletRequest request, @RequestBody User user) {
        String password = user.getPassword();//拿到页面发来的密码，存入password
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());//工具类进行md5加密

        log.info("login.........");
        //查数据库
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername, user.getUsername());//查用户

        User user1 = userService.getOne(userLambdaQueryWrapper);

        if (user1 == null) {
            return R.error("用户名不能为空");
        }
        if (!user1.getPassword().equals(password)) {
            return R.error("密码错误，滚蛋!");
        }

        //登录成功
        request.getSession().setAttribute("user", user1.getId());
//        return user ;
        return R.success(user1);
    }

    /**
     * 根据前端传过来的角色id查询应该显示的页面（1为学生、2为管理员、3为老师）
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public R<List<User>> getStudents(@PathVariable int id) {
        List<User> users = userService.selectByIdWithRole(id);
        return R.success(users);
    }


    // TODO: 2023/2/14 未进行校验，之间返回了添加成功
    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping
    public R<User> newUser(@RequestBody User user)
    {
        userService.save(user);
        return R.success(user);
    }

    @PutMapping
    public R<User> updateUser(@RequestBody User user)
    {
        userService.updateById(user);
        return R.success(user);
    }

    @DeleteMapping("{id}")
    public R<String> deleteUser(@PathVariable int id)
    {
        userService.removeById(id);
        return R.success("用户以删除");
    }
}
