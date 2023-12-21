package com.winmanboo.bluebook.main.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.main.entity.Topic;
import com.winmanboo.bluebook.main.mapper.TopicMapper;
import com.winmanboo.bluebook.main.service.TopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winmanboo.bluebook.main.vo.PostsDetailsVO;
import com.winmanboo.bluebook.main.vo.PostsVO;
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
    public PageList<PostsVO> pageVoByCategoryId(PageParam pageParam, Long categoryId) {
        IPage<PostsVO> page = baseMapper.pageList(pageParam.toPage(), categoryId);
        return PageList.turnTo(page);
    }

    @Override
    public PostsDetailsVO detailsByPostId(Long postId) {
        return baseMapper.detailsByPostId(postId);
    }
}