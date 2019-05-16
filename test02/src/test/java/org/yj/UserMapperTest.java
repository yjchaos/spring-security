package org.yj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yj.domain.Permission;
import org.yj.domain.User;
import org.yj.mapper.UserMapper;

import java.util.List;

/**
 * @author yaojun
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-context.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindUserByUsername() {
        User user = userMapper.findByUsername("eric");
        System.out.println(user);
    }

    @Test
    public void testFindPermissionByUsername() {
        List<Permission> list = userMapper.findPermissionByUsername("jack");
        list.forEach(System.out::println);
    }

    @Test
    public void testUpdatePassword() {
        User user = new User();
        user.setUsername("jack");

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        user.setPassword(passwordEncoder.encode("123456"));
        userMapper.updatePassword(user);
    }
}
