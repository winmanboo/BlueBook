package com.winmanboo.bluebook.admin.mapping;

import com.winmanboo.bluebook.admin.dto.DeptDTO;
import com.winmanboo.bluebook.admin.entity.Dept;
import com.winmanboo.bluebook.admin.vo.DeptVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author winmanboo
 * @date 2023/7/18 14:43
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeptMapping {
    DeptVo toDeptVo(Dept dept);

    Dept toDept(DeptDTO deptDTO);
}
