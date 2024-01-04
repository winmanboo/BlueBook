package com.winmanboo.bluebook.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.winmanboo.bluebook.admin.dto.RoleDTO;
import com.winmanboo.bluebook.admin.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winmanboo.bluebook.api.admin.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统角色 Mapper 接口
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 页面列表
     *
     * @param page    页面
     * @param roleDTO 角色dto
     * @return {@link IPage}<{@link RoleVO}>
     */
    IPage<RoleVO> pageList(@Param("page") Page<RoleVO> page, @Param("role") RoleDTO roleDTO);

    /**
     * 角色列表
     *
     * @return {@link List}<{@link RoleVO}>
     */
    List<RoleVO> listVo();

    /**
     * 根据用户id和租户id查询用户角色信息
     *
     * @param userId   用户id
     * @param tenantId 租户id
     * @return 角色列表
     */
    List<RoleVO> loadRolesByUserIdAndTenantId(@Param("userId") Long userId, @Param("tenantId") Long tenantId);
}
