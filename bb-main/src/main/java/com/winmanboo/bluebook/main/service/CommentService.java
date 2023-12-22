package com.winmanboo.bluebook.main.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.main.entity.Comment;
import com.winmanboo.bluebook.main.vo.CommentVO;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
public interface CommentService extends IService<Comment> {


    /**
     * 根据主题 id 查询评论分页
     *
     * @param pageParam 分页参数
     * @param topicId   主题 id
     * @return 评论分页
     */
    PageList<CommentVO> pageByTopicId(PageParam pageParam, Long topicId);
}
