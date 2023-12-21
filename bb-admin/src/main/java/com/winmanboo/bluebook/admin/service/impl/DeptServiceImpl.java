package com.winmanboo.bluebook.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winmanboo.bluebook.admin.dto.DeptDTO;
import com.winmanboo.bluebook.admin.entity.Dept;
import com.winmanboo.bluebook.admin.mapper.DeptMapper;
import com.winmanboo.bluebook.admin.service.DeptService;
import com.winmanboo.bluebook.admin.utils.DeptHelper;
import com.winmanboo.bluebook.admin.vo.DeptVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Override
    public List<DeptVo> listDeptVo(DeptDTO deptDTO) {
        List<DeptVo> deptVoList = baseMapper.listDeptVo(deptDTO);
        List<DeptVo> tree = DeptHelper.generateDeptTree(deptVoList);
        return tree.isEmpty() ? deptVoList : tree;
    }
}
