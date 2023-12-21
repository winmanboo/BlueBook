package com.winmanboo.bluebook.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.winmanboo.bluebook.admin.dto.RoleDTO;
import com.winmanboo.bluebook.admin.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winmanboo.bluebook.admin.vo.RoleVo;
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
     * @return {@link IPage}<{@link RoleVo}>
     */
    IPage<RoleVo> pageList(@Param("page") Page<RoleVo> page, @Param("role") RoleDTO roleDTO);

    /**
     * 角色列表
     *
     * @return {@link List}<{@link RoleVo}>
     */
    List<RoleVo> listVo();
}
