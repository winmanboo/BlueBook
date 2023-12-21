package com.winmanboo.bluebook.admin.mapping;

import com.winmanboo.bluebook.admin.dto.UserDTO;
import com.winmanboo.bluebook.admin.entity.User;
import com.winmanboo.bluebook.admin.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author winmanboo
 * @date 2023/7/5 15:38
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapping {

    UserVo toUserVo(User user);

    User toUser(UserDTO userDTO);
}
