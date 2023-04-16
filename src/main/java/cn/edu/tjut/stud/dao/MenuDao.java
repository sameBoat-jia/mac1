package cn.edu.tjut.stud.dao;

import cn.edu.tjut.stud.domain.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

///**
//* @author jiatongzhou
//* @description 针对表【menu】的数据库操作Mapper
//* @createDate 2023-02-12 12:12:33
//* @Entity generator.domain.Menu
//*/


/**
 * 菜单刀
 *
 * @author jiatongzhou
 * @date 2023/02/25
 */
@Mapper
public interface MenuDao extends BaseMapper<Menu> {

    /**
     * 找到所有
     *
     * @return {@link List}<{@link Menu}>
     */
    @Select("select * from menu")
    List<Menu> findAll();

    /**
     * 找到用户
     *
     * @param username 用户名
     * @return {@link List}<{@link Menu}>
     */
    @Select(value = "select m.* from menu m inner join role_menu rm on m.id=rm.menu_id where " +
            "rm.role_id in ( select ur.role_id from user_role ur inner join " +
            "user u on ur.user_id=u.id where u.username = #{username}) ")
    List<Menu> findByUser(String username);
}




