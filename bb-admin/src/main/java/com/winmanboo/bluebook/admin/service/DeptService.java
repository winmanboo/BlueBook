package com.winmanboo.bluebook.admin.service;

import com.winmanboo.bluebook.admin.dto.DeptDTO;
import com.winmanboo.bluebook.admin.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.winmanboo.bluebook.admin.vo.DeptVo;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
public interface DeptService extends IService<Dept> {

    /**
     * 部门列表
     *
     * @param deptDTO 部门参数
     * @return {@link List}<{@link DeptVo}>
     */
    List<DeptVo> listDeptVo(DeptDTO deptDTO);
}
