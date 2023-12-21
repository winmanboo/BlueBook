package com.winmanboo.bluebook.main.controller;

import com.winmanboo.bluebook.base.BaseController;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.main.vo.PostsDetailsVO;
import com.winmanboo.bluebook.result.Result;
import com.winmanboo.bluebook.main.service.TopicService;
import com.winmanboo.bluebook.main.vo.PostsVO;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

/**
 * <p>
 * 帖子表 前端控制器
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/main/posts")
public class TopicController extends BaseController {

    private final TopicService topicService;

    @GetMapping("/page/{categoryId}")
    @ApiOperation(value = "帖子分页列表", notes = "根据所属分类查询帖子分页列表")
    public Result<PageList<PostsVO>> page(@Valid PageParam pageParam, @PathVariable("categoryId") Long categoryId) {
        if (Objects.isNull(categoryId)) {
            return fail("分类 id 不能为空");
        }
        PageList<PostsVO> pageList = topicService.pageVoByCategoryId(pageParam, categoryId);
        return ok(pageList);
    }

    @GetMapping("/details/{postId}")
    @ApiOperation(value = "获取帖子详情", notes = "根据帖子 id 获取详情")
    public Result<PostsDetailsVO> details(@PathVariable Long postId) {
        if (Objects.isNull(postId)) {
            return fail("postId 不能为空");
        }
        PostsDetailsVO detailsVO = topicService.detailsByPostId(postId);
        return ok(detailsVO);
    }
}
