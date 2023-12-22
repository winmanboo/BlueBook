package com.winmanboo.bluebook.main.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author winmanboo
 * @date 2023/12/22 15:08
 */
@Data
public class ReplyVO {
    private Long id;

    @ApiModelProperty("评论 id")
    private Long commentId;

    @ApiModelProperty("回复目标的 id")
    private Long replyId;

    @ApiModelProperty("回复类型 0：针对评论的回复 1：针对回复的回复")
    private Integer replyType;

    @ApiModelProperty("回复内容")
    private String content;

    @ApiModelProperty("回复用户 id")
    private Long fromUid;

    @ApiModelProperty("回复用户的用户名")
    private String fromUsername;

    @ApiModelProperty("回复用户的头像")
    private String fromAvatar;

    @ApiModelProperty("目标用户 id")
    private Long toUid;

    @ApiModelProperty("目标用户的用户名")
    private String toUsername;
}
