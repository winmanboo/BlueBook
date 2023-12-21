package com.winmanboo.bluebook.main.mapping;

import com.winmanboo.bluebook.main.entity.Category;
import com.winmanboo.bluebook.main.vo.CategoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import java.util.List;

/**
 * @author winmanboo
 * @date 2023/12/13 22:06
 */
@Mapper(componentModel = ComponentModel.SPRING)
public interface CategoryMapping {
    List<CategoryVO> toCategoryVos(List<Category> categories);
}
