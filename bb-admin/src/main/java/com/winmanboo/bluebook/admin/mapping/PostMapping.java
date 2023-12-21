package com.winmanboo.bluebook.admin.mapping;

import com.winmanboo.bluebook.admin.dto.PostDTO;
import com.winmanboo.bluebook.admin.entity.Post;
import com.winmanboo.bluebook.admin.vo.PostVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author winmanboo
 * @date 2023/7/18 18:17
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapping {

    Post toPost(PostDTO postDTO);

    PostVo toPostVo(Post post);
}
