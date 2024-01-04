package com.winmanboo.bluebook.admin.controller.feign;

import com.winmanboo.bluebook.admin.service.RoleService;
import com.winmanboo.bluebook.api.admin.feign.RoleFeignClient;
import com.winmanboo.bluebook.api.admin.vo.RoleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author winmanboo
 * @date 2024/1/4 14:03
 */
@RestController
@RequiredArgsConstructor
public class RoleFeignController implements RoleFeignClient {

    private final RoleService roleService;


    @Override
    public List<RoleVO> loadAllRoles(Long tenantId) {
        return roleService.loadAllRoles(tenantId);
    }

    @Override
    public List<RoleVO> loadRolesByUserIdAndTenantId(Long userId, Long tenantId) {
        return roleService.loadRolesByUserIdAndTenantId(userId, tenantId);
    }
}
