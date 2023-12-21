package com.winmanboo.bluebook.admin.service;

import com.winmanboo.bluebook.admin.dto.RoleDTO;
import com.winmanboo.bluebook.admin.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.winmanboo.bluebook.admin.vo.RoleVo;
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
     * @return {@link PageList}<{@link RoleVo}>
     */
    PageList<RoleVo> pageList(PageParam pageParam, RoleDTO roleDTO);

    /**
     * 角色列表
     *
     * @return {@link List}<{@link RoleVo}>
     */
    List<RoleVo> listVo();
}
