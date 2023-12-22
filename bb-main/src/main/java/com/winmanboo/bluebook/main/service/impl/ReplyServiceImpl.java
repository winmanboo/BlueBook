package com.winmanboo.bluebook.main.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.main.entity.Reply;
import com.winmanboo.bluebook.main.mapper.ReplyMapper;
import com.winmanboo.bluebook.main.service.ReplyService;
import com.winmanboo.bluebook.main.vo.ReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author winmanboo
 * @date 2023/12/22 15:07
 */
@Service
@RequiredArgsConstructor
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {

    @Override
    public PageList<ReplyVO> pageByCommentId(PageParam pageParam, Long commentId) {
        IPage<ReplyVO> page = baseMapper.pageByCommentId(pageParam.toPage(), commentId);
        List<ReplyVO> replies = page.getRecords();
        // TODO: 远程批量获取用户信息

        replies.forEach(reply -> {
            // TODO: 组装用户信息
        });

        return PageList.turnTo(page);
    }
}
