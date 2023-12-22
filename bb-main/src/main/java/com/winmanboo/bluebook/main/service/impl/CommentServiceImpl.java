package com.winmanboo.bluebook.main.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.main.entity.Comment;
import com.winmanboo.bluebook.main.mapper.CommentMapper;
import com.winmanboo.bluebook.main.service.CommentService;
import com.winmanboo.bluebook.main.service.ReplyService;
import com.winmanboo.bluebook.main.vo.CommentVO;
import com.winmanboo.bluebook.main.vo.ReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    private final ReplyService replyService;

    @Override
    public PageList<CommentVO> pageByTopicId(PageParam pageParam, Long topicId) {
        IPage<CommentVO> page = baseMapper.pageByTopicId(pageParam.toPage(), topicId);
        List<CommentVO> comments = page.getRecords();

        List<Long> fromUids = comments.stream().map(CommentVO::getFromUid).toList();
        // TODO: 远程批量获取用户信息


        comments.forEach(comment -> {
            // TODO: 组装用户信息

            PageParam replyPageParam = new PageParam(1, 10);
            PageList<ReplyVO> replyPageList = replyService.pageByCommentId(replyPageParam, comment.getId());
            comment.setReplies(replyPageList.getList());
            comment.setReplyCount(replyPageList.getTotal());
        });
        return PageList.turnTo(page);
    }
}
