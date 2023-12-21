package com.winmanboo.bluebook.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.winmanboo.bluebook.admin.dto.RoleDTO;
import com.winmanboo.bluebook.admin.entity.Role;
import com.winmanboo.bluebook.admin.mapper.RoleMapper;
import com.winmanboo.bluebook.admin.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winmanboo.bluebook.admin.vo.RoleVo;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统角色 服务实现类
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public PageList<RoleVo> pageList(PageParam pageParam, RoleDTO roleDTO) {
        IPage<RoleVo> page = baseMapper.pageList(pageParam.toPage(), roleDTO);
        return PageList.turnTo(page);
    }

    @Override
    public List<RoleVo> listVo() {
        return baseMapper.listVo();
    }
}
