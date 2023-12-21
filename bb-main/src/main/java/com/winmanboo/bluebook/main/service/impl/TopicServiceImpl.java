package com.winmanboo.bluebook.main.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.main.entity.Topic;
import com.winmanboo.bluebook.main.mapper.TopicMapper;
import com.winmanboo.bluebook.main.service.TopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winmanboo.bluebook.main.vo.TopicDetailsVO;
import com.winmanboo.bluebook.main.vo.TopicVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖子表 服务实现类
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
@Service
@RequiredArgsConstructor
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {

    @Override
    public PageList<TopicVO> pageVoByCategoryId(PageParam pageParam, Long categoryId) {
        IPage<TopicVO> page = baseMapper.pageList(pageParam.toPage(), categoryId);
        return PageList.turnTo(page);
    }

    @Override
    public TopicDetailsVO detailsByPostId(Long postId) {
        return baseMapper.detailsByPostId(postId);
    }
}
