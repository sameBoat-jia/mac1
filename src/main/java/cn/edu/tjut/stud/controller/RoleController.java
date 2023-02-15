package cn.edu.tjut.stud.controller;


import cn.edu.tjut.stud.common.R;
import cn.edu.tjut.stud.domain.UserRole;
import cn.edu.tjut.stud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiatongzhou
 */
@RestController
@RequestMapping("/api/role")
public class RoleController
{
    @Autowired
    private RoleService roleService;

//    @PutMapping
//    public R<Role> setRole(@RequestBody Role role)
//    {
//        roleService.updateById(role);
//        return R.success(role);
//    }
//    @PutMapping
//    public R<UserRole> mySet(@RequestBody UserRole userRole)
//    {
//        roleService.updateById(userRole);
//        return R.success(userRole);
//    }

    @PutMapping
    public R<UserRole> updateUser(@RequestBody UserRole userRole)
    {
        userRole.setRoleId(2);
        roleService.updateById(userRole);
        return R.success(userRole);
    }

    @PostMapping
    public R<UserRole> newUser(@RequestBody UserRole user)
    {
        roleService.save(user);
        return R.success(user);
    }
    @GetMapping
    public R<List<UserRole>> getAll()
    {
        List<UserRole> list = roleService.list();
        return R.success(list);
    }
}
