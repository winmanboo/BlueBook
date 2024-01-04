package com.winmanboo.bluebook.api.admin.feign;

import com.winmanboo.bluebook.api.admin.vo.RoleVO;
import com.winmanboo.bluebook.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author winmanboo
 * @date 2024/1/4 13:43
 */
@FeignClient(value = "bb-admin", contextId = "role")
public interface RoleFeignClient {
    /**
     * 查询所有的角色标识
     *
     * @param tenantId 租户id
     * @return 角色标识 Code 列表
     */
    @GetMapping("/role/all")
    Result<List<RoleVO>> loadAllRoles(@RequestParam("tenantId") Long tenantId);

    /**
     * 查询用户的角色标识
     *
     * @param userId   用户id
     * @param tenantId 租户id
     * @return 角色标识 Code 列表
     */
    @GetMapping("/role/byUserId")
    Result<List<RoleVO>> loadRolesByUserIdAndTenantId(@RequestParam("userId") Long userId, @RequestParam("tenantId") Long tenantId);
}
