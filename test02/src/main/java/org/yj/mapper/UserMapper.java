package org.yj.mapper;

import org.yj.domain.Permission;
import org.yj.domain.User;

import java.util.List;

/**
 * @author yaojun
 */
public interface UserMapper {
    /**
     * 查询当前用户对象
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 查询当前用户拥有的权限
     * @param username
     * @return
     */
    List<Permission> findPermissionByUsername(String username);

    /**
     * 修改密码
     * @param user
     */
    void updatePassword(User user);
}
