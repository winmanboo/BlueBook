package com.winmanboo.bluebook.uaa.service.impl;

import com.winmanboo.bluebook.exception.JiamingException;
import com.winmanboo.bluebook.uaa.entity.Role;
import com.winmanboo.bluebook.uaa.entity.SecurityUser;
import com.winmanboo.bluebook.uaa.entity.User;
import com.winmanboo.bluebook.uaa.service.RoleService;
import com.winmanboo.bluebook.uaa.service.UserService;
import com.winmanboo.bluebook.utils.SystemUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author winmanboo
 * @date 2023/5/23 14:56
 */
@Component
@RequiredArgsConstructor
public class UaaUserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    private final RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.loadUserByUsername(username);

        if (null == user) {
            throw new UsernameNotFoundException("用户不存在");
        }

        if (user.getStatus() == 0) {
            throw new JiamingException("用户已被禁用，请联系管理员");
        }

        List<Role> roleList;

        if (SystemUtil.isAdmin(user.getIsAdmin())) { // 如果是管理员
            roleList = roleService.loadAllRoles(user.getTenantId());
        } else { // 如果不是管理员
            roleList = roleService.loadRolesByUserIdAndTenantId(user.getId(), user.getTenantId());
        }

        List<GrantedAuthority> authorities = roleList == null ? Collections.emptyList() : roleList.stream()
                .map(Role::getCode)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ADMIN"));

        SecurityUser securityUser = new SecurityUser(user.getUsername(), user.getPassword(), authorities);
        securityUser.setUserId(user.getId());
        securityUser.setIsAdmin(user.getIsAdmin());
        securityUser.setTenantId(user.getTenantId());
        return securityUser;
    }
}
