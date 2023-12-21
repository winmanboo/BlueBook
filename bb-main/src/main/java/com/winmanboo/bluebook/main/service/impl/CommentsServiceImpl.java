package com.winmanboo.bluebook.main.service.impl;

import com.winmanboo.bluebook.main.entity.Comments;
import com.winmanboo.bluebook.main.mapper.CommentsMapper;
import com.winmanboo.bluebook.main.service.CommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

}
