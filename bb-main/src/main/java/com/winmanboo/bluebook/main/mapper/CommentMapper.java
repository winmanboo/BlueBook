package com.winmanboo.bluebook.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.winmanboo.bluebook.main.entity.Comment;
import com.winmanboo.bluebook.main.vo.CommentVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 根据主题 id 查询评论分页
     *
     * @param page    分页参数
     * @param topicId 主题 id
     * @return 分页
     */
    IPage<CommentVO> pageByTopicId(@Param("page") IPage<CommentVO> page, @Param("topicId") Long topicId);
}
