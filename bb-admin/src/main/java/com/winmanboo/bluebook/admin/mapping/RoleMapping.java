package com.winmanboo.bluebook.admin.mapping;

import com.winmanboo.bluebook.admin.dto.RoleDTO;
import com.winmanboo.bluebook.admin.entity.Role;
import com.winmanboo.bluebook.admin.vo.RoleVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author winmanboo
 * @date 2023/7/5 15:38
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapping {

    RoleVo toRoleVo(Role role);

    Role toRole(RoleDTO roleDTO);
}
