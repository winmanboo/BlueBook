package com.winmanboo.bluebook.main.controller;

import com.winmanboo.bluebook.base.BaseController;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.main.service.CommentService;
import com.winmanboo.bluebook.main.vo.CommentVO;
import com.winmanboo.bluebook.result.Result;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/main/comment")
public class CommentController extends BaseController {

    private final CommentService commentService;

    @GetMapping("/page/{topicId}")
    @ApiOperation(value = "评论分页", notes = "根据 topicId 查询评论分页")
    public Result<PageList<CommentVO>> page(@Valid PageParam pageParam, @PathVariable Long topicId) {
        PageList<CommentVO> pageList = commentService.pageByTopicId(pageParam, topicId);
        return ok(pageList);
    }

}
