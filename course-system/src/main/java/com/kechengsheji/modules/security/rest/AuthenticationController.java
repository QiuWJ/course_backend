package com.kechengsheji.modules.security.rest;

import com.kechengsheji.modules.security.security.AuthenticationInfo;
import com.kechengsheji.modules.security.security.AuthorizationUser;
import com.kechengsheji.modules.security.security.JwtUser;
import com.kechengsheji.modules.security.utils.JwtTokenUtil;
import com.kechengsheji.service.StudentService;
import com.kechengsheji.utils.EncryptUtil;
import com.kechengsheji.utils.ResultUtil;
import com.kechengsheji.utils.SecurityContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 授权、根据token获取用户详细信息
 *
 * @author songshoubin
 * @date 2019-6-22
 */
@Slf4j
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private StudentService studentService;

    /**
     * 登录授权
     *
     * @param authorizationUser
     * @return
     */

    @PostMapping(value = "${jwt.auth.path}")
    public ResponseEntity login(@Validated @RequestBody AuthorizationUser authorizationUser) {
        String username = authorizationUser.getUsername();
        final JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (!jwtUser.getPassword().equals(EncryptUtil.encryptPassword(authorizationUser.getPassword()))) {
            return ResponseEntity.ok(new ResultUtil(401,"密码错误"));
        }


        // 生成令牌
        final String token = jwtTokenUtil.generateToken(jwtUser);
        AuthenticationInfo authenticationInfo = new AuthenticationInfo(token, jwtUser);
        ResultUtil result = new ResultUtil(200,authenticationInfo);
        // 返回 token
        return ResponseEntity.ok(result);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping(value = "${jwt.auth.account}")
    public ResponseEntity getUserInfo() {
        UserDetails userDetails = SecurityContextHolder.getUserDetails();
        JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(userDetails.getUsername());
        return ResponseEntity.ok(jwtUser);
    }
}
