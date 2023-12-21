package com.winmanboo.bluebook.admin.service;

import com.winmanboo.bluebook.admin.dto.PostDTO;
import com.winmanboo.bluebook.admin.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.winmanboo.bluebook.admin.vo.PostVo;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;

import java.util.List;

/**
 * <p>
 * 岗位表 服务类
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
public interface PostService extends IService<Post> {

    /**
     * 岗位列表
     *
     * @return {@link List}<{@link PostVo}>
     */
    List<PostVo> listVo();

    /**
     * 岗位分页
     *
     * @param pageParam 页面参数
     * @param postDTO   岗位参数
     * @return {@link PageList}<{@link PostVo}>
     */
    PageList<PostVo> pageVo(PageParam pageParam, PostDTO postDTO);
}
