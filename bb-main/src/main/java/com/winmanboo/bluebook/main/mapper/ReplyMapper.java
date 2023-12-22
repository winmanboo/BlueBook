package com.winmanboo.bluebook.main.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.winmanboo.bluebook.main.entity.Reply;
import com.winmanboo.bluebook.main.vo.ReplyVO;
import org.apache.ibatis.annotations.Param;

/**
 * @author winmanboo
 * @date 2023/12/22 15:06
 */
public interface ReplyMapper extends BaseMapper<Reply> {
    /**
     * 根据评论 id 获取回复分页
     *
     * @param page      分页参数
     * @param commentId 评论 id
     * @return 回复分页信息
     */
    IPage<ReplyVO> pageByCommentId(@Param("page") IPage<ReplyVO> page, @Param("commentId") Long commentId);
}
