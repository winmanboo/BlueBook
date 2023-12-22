package com.winmanboo.bluebook.main.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author winmanboo
 * @date 2023/12/21 19:38
 */
@Data
public class CommentVO {
    @ApiModelProperty("评论 id")
    private Long id;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("评论用户的 id")
    private Long fromUid;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("作者头像")
    private String avatar;

    @ApiModelProperty("发布时间")
    private String createTime;

    @ApiModelProperty("回复列表，默认一开始只给一页数据")
    private List<ReplyVO> replies;

    @ApiModelProperty("回复总数")
    private Long replyCount;
}
