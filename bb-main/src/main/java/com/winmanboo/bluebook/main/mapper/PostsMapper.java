package com.winmanboo.bluebook.main.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.winmanboo.bluebook.main.entity.Posts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winmanboo.bluebook.main.vo.PostsVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 帖子表 Mapper 接口
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
public interface PostsMapper extends BaseMapper<Posts> {

    /**
     * 帖子分页列表
     *
     * @param page       分页条件
     * @param categoryId 分类 id
     * @return 帖子分页列表
     */
    IPage<PostsVO> pageList(@Param("page") IPage<PostsVO> page, @Param("categoryId") Long categoryId);
}
