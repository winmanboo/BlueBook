package com.winmanboo.bluebook.admin.mapping;

import com.winmanboo.bluebook.admin.dto.MenuDTO;
import com.winmanboo.bluebook.admin.entity.Menu;
import com.winmanboo.bluebook.admin.mapping.convert.BooleanIntegerConverter;
import com.winmanboo.bluebook.admin.vo.RouteVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author winmanboo
 * @date 2023/7/5 15:38
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = BooleanIntegerConverter.class)
public interface MenuMapping {

    RouteVo toRouteVo(Menu menu);

    Menu toMenu(MenuDTO menuDTO);
}
