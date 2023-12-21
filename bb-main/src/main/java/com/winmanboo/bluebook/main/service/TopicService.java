package com.winmanboo.bluebook.main.service;

import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.main.entity.Topic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.winmanboo.bluebook.main.vo.PostsDetailsVO;
import com.winmanboo.bluebook.main.vo.PostsVO;

/**
 * <p>
 * 帖子表 服务类
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
public interface TopicService extends IService<Topic> {

    /**
     * 根据类目 id 查询帖子分页列表
     *
     * @param pageParam  分页参数
     * @param categoryId 分类id
     * @return
     */
    PageList<PostsVO> pageVoByCategoryId(PageParam pageParam, Long categoryId);

    /**
     * 根据 postId 查询详情
     *
     * @param postId 帖子 id
     * @return 帖子详情
     */
    PostsDetailsVO detailsByPostId(Long postId);
}
