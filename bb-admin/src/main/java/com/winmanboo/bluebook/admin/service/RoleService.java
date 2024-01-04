package com.winmanboo.bluebook.admin.service;

import com.winmanboo.bluebook.admin.dto.RoleDTO;
import com.winmanboo.bluebook.admin.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.winmanboo.bluebook.api.admin.vo.RoleVO;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;

import java.util.List;

/**
 * <p>
 * 系统角色 服务类
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
public interface RoleService extends IService<Role> {

    /**
     * 页面列表
     *
     * @param pageParam 页面参数
     * @param roleDTO   角色dto
     * @return {@link PageList}<{@link RoleVO}>
     */
    PageList<RoleVO> pageList(PageParam pageParam, RoleDTO roleDTO);

    /**
     * 角色列表
     *
     * @return {@link List}<{@link RoleVO}>
     */
    List<RoleVO> listVo();

    /**
     * 查询所有的角色信息
     *
     * @param tenantId 租户id
     * @return 角色列表
     */
    List<RoleVO> loadAllRoles(Long tenantId);

    /**
     * 查询用户的角色信息
     *
     * @param userId   用户id
     * @param tenantId 租户id
     * @return 角色列表
     */
    List<RoleVO> loadRolesByUserIdAndTenantId(Long userId, Long tenantId);
}
