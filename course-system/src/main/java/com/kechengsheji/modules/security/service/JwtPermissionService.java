package com.kechengsheji.modules.security.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * jwt会员权限服务类
 *
 * @author songshoubin
 * @date 2019-5-15
 */
@Slf4j
@Service
public class JwtPermissionService {

    @Cacheable(key = "'loadPermissionByMember:' + #p0.username")
    public Collection<GrantedAuthority> mapToGrantedAuthorities(String role) {



        Set<SimpleGrantedAuthority> permissions = new HashSet<>();

        permissions.add(new SimpleGrantedAuthority(role));

        return permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getAuthority()))
                .collect(Collectors.toList());
    }
}
