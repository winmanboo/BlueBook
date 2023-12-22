package com.winmanboo.bluebook.main.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.main.entity.Reply;
import com.winmanboo.bluebook.main.vo.ReplyVO;

/**
 * @author winmanboo
 * @date 2023/12/22 15:07
 */
public interface ReplyService extends IService<Reply> {
    /**
     * 根据评论 id 获取回复分页信息
     *
     * @param pageParam 分页参数
     * @param commentId 评论 id
     * @return 回复分页信息
     */
    PageList<ReplyVO> pageByCommentId(PageParam pageParam, Long commentId);
}
