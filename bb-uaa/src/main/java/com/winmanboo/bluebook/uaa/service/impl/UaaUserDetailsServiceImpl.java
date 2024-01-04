package com.winmanboo.bluebook.uaa.service.impl;

import com.winmanboo.bluebook.api.admin.feign.RoleFeignClient;
import com.winmanboo.bluebook.api.admin.vo.RoleVO;
import com.winmanboo.bluebook.constants.AuthConstant;
import com.winmanboo.bluebook.exception.JiamingException;
import com.winmanboo.bluebook.uaa.constants.SysType;
import com.winmanboo.bluebook.uaa.entity.AuthAccount;
import com.winmanboo.bluebook.uaa.entity.SecurityUser;
import com.winmanboo.bluebook.uaa.service.AuthAccountService;
import com.winmanboo.bluebook.utils.SystemUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author winmanboo
 * @date 2023/5/23 14:56
 */
@Component
@RequiredArgsConstructor
public class UaaUserDetailsServiceImpl implements UserDetailsService {

    private final AuthAccountService authAccountService;

    private final RoleFeignClient roleFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthAccount authAccount = authAccountService.loadAccountByUsername(username);

        if (Objects.isNull(authAccount)) {
            throw new UsernameNotFoundException("用户不存在");
        }

        if (authAccount.getStatus() == 0) {
            throw new JiamingException("用户已被禁用，请联系管理员");
        }

        List<RoleVO> roleList;

        // XXX: 理论上管理端要细化为平台端和商家端
        if (Objects.equals(authAccount.getSysType(), SysType.ADMIN.getValue())) { // 管理端
            if (SystemUtil.isAdmin(authAccount.getIsAdmin())) {
                roleList = roleFeignClient.loadAllRoles(authAccount.getTenantId());
            } else {
                roleList = roleFeignClient.loadRolesByUserIdAndTenantId(authAccount.getId(), authAccount.getTenantId());
            }
        } else { // 普通用户
            RoleVO ordinaryAuthority = new RoleVO();
            ordinaryAuthority.setCode(AuthConstant.ORDINARY_AUTHORITY);
            roleList = Collections.singletonList(ordinaryAuthority);
        }

        List<SimpleGrantedAuthority> authorities = roleList == null ? Collections.emptyList() : roleList.stream()
                .map(RoleVO::getCode)
                .map(SimpleGrantedAuthority::new)
                .toList();

        SecurityUser securityUser = new SecurityUser(authAccount.getUsername(), authAccount.getPassword(), authorities);
        securityUser.setUserId(authAccount.getId());
        securityUser.setIsAdmin(authAccount.getIsAdmin());
        securityUser.setTenantId(authAccount.getTenantId());
        return securityUser;
    }
}
