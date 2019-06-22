package com.kechengsheji.base;

import com.kechengsheji.modules.security.security.JwtUser;
import com.kechengsheji.modules.security.service.JwtUserDetailsService;
import com.kechengsheji.utils.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 基础Controller
 *
 * @author shen
 * @date 2019-6-5
 */
public class BaseController {

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    //返回会员id
    public Integer getMemberId() {
        UserDetails userDetails = SecurityContextHolder.getUserDetails();
        final JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(userDetails.getUsername());
        return jwtUser.getId();
    }
}
