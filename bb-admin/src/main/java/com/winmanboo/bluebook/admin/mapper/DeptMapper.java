package com.winmanboo.bluebook.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winmanboo.bluebook.admin.dto.DeptDTO;
import com.winmanboo.bluebook.admin.entity.Dept;
import com.winmanboo.bluebook.admin.vo.DeptVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
public interface DeptMapper extends BaseMapper<Dept> {

    /**
     * 部门列表
     *
     * @param deptDTO 部门参数
     * @return {@link List}<{@link DeptVo}>
     */
    List<DeptVo> listDeptVo(@Param("dept") DeptDTO deptDTO);
}
