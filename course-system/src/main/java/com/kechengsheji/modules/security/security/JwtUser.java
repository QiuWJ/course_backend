package com.kechengsheji.modules.security.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;

/**
 * @author jie
 * @date 2018-11-23
 */
@Getter
@AllArgsConstructor
public class JwtUser implements UserDetails {

    @JsonIgnore
    private final Integer id;

    private final String number;

    @JsonIgnore
    private final String password;

    private final String grade;

    private final String username;

    private final String phone;

    private final String sex;

    private final String deptName;

    private final String major;

    private final String className;

    @JsonIgnore
    private final Date resetPasswordDate;

    @JsonIgnore
    private final Collection<GrantedAuthority> authorities;


    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

}
