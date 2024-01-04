package com.winmanboo.bluebook.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.winmanboo.bluebook.admin.dto.RoleDTO;
import com.winmanboo.bluebook.admin.entity.Role;
import com.winmanboo.bluebook.admin.mapper.RoleMapper;
import com.winmanboo.bluebook.admin.mapping.RoleMapping;
import com.winmanboo.bluebook.admin.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winmanboo.bluebook.api.admin.vo.RoleVO;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 系统角色 服务实现类
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    private final RoleMapping roleMapping;

    @Override
    public PageList<RoleVO> pageList(PageParam pageParam, RoleDTO roleDTO) {
        IPage<RoleVO> page = baseMapper.pageList(pageParam.toPage(), roleDTO);
        return PageList.turnTo(page);
    }

    @Override
    public List<RoleVO> listVo() {
        return baseMapper.listVo();
    }

    @Override
    public List<RoleVO> loadAllRoles(Long tenantId) {
        List<Role> roles = lambdaQuery().eq(Objects.nonNull(tenantId), Role::getTenantId, tenantId).list();
        return roleMapping.toRoleVos(roles);
    }

    @Override
    public List<RoleVO> loadRolesByUserIdAndTenantId(Long userId, Long tenantId) {
        return baseMapper.loadRolesByUserIdAndTenantId(userId, tenantId);
    }

}
