package com.winmanboo.bluebook.main.service;

import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.main.entity.Posts;
import com.baomidou.mybatisplus.extension.service.IService;
import com.winmanboo.bluebook.main.vo.PostsVO;

/**
 * <p>
 * 帖子表 服务类
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
public interface PostsService extends IService<Posts> {

    /**
     * @param pageParam 分页参数
     * @param categoryId 分类id
     * @return
     */
    PageList<PostsVO> pageVoByCategoryId(PageParam pageParam, Long categoryId);
}
