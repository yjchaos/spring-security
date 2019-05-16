package org.yj.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author yaojun
 */
@ToString
public class User implements UserDetails {

    // ~ Instance fields
    // ================================================================================================

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String realname;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Date createdTime;

    @Getter
    @Setter
    private Date lastLoginDate;

    @Getter
    @Setter
    private boolean enabled;

    @Getter
    @Setter
    private boolean accountNonExpired;

    @Getter
    @Setter
    private boolean accountNonLocked;

    @Getter
    @Setter
    private boolean credentialsNonExpired;

    /**
     * 用户拥有的所有权限
     */
    @Getter
    @Setter
    private List<GrantedAuthority> authorityList = new ArrayList<>();

    // ~ Constructors
    // ===================================================================================================

    // ~ Methods
    // ========================================================================================================


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }
}
