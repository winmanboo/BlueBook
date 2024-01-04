package com.winmanboo.bluebook.admin.controller.feign;

import com.winmanboo.bluebook.admin.service.RoleService;
import com.winmanboo.bluebook.api.admin.feign.RoleFeignClient;
import com.winmanboo.bluebook.api.admin.vo.RoleVO;
import com.winmanboo.bluebook.base.BaseController;
import com.winmanboo.bluebook.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author winmanboo
 * @date 2024/1/4 14:03
 */
@RestController
@RequiredArgsConstructor
public class RoleFeignController extends BaseController implements RoleFeignClient {

    private final RoleService roleService;

    @Override
    public Result<List<RoleVO>> loadAllRoles(Long tenantId) {
        return ok(roleService.loadAllRoles(tenantId));
    }

    @Override
    public Result<List<RoleVO>> loadRolesByUserIdAndTenantId(Long userId, Long tenantId) {
        return ok(roleService.loadRolesByUserIdAndTenantId(userId, tenantId));
    }
}
