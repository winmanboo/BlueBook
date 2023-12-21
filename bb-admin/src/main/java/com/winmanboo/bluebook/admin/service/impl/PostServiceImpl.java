package com.winmanboo.bluebook.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.winmanboo.bluebook.admin.dto.PostDTO;
import com.winmanboo.bluebook.admin.entity.Post;
import com.winmanboo.bluebook.admin.mapper.PostMapper;
import com.winmanboo.bluebook.admin.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winmanboo.bluebook.admin.vo.PostVo;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.security.context.UserInfoContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 岗位表 服务实现类
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
@Service
@RequiredArgsConstructor
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Override
    public List<PostVo> listVo() {
        Long tenantId = UserInfoContext.get().getTenantId();
        return baseMapper.listVo(tenantId);
    }

    @Override
    public PageList<PostVo> pageVo(PageParam pageParam, PostDTO postDTO) {
        IPage<PostVo> page = baseMapper.pageVo(pageParam.toPage(), postDTO);
        return PageList.turnTo(page);
    }
}
