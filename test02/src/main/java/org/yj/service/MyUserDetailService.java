package org.yj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.yj.domain.Permission;
import org.yj.domain.User;
import org.yj.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaojun
 */
@Service("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {

    // ~ Static fields/initializers
    // =====================================================================================

    // ~ Instance fields
    // ================================================================================================


    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // ~ Constructors
    // ===================================================================================================

    // ~ Methods
    // ========================================================================================================


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(s);
        if (user != null) {
            List<Permission> permissionList = userMapper.findPermissionByUsername(s);
            List<GrantedAuthority> authorities = new ArrayList<>();

            permissionList.forEach(p->{
                GrantedAuthority authority = new SimpleGrantedAuthority(p.getPermTag());
                authorities.add(authority);
            });

            user.setAuthorityList(authorities);
        }
        return user;
    }
}
