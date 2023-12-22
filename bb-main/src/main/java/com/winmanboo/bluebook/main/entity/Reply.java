package com.winmanboo.bluebook.main.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.winmanboo.bluebook.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author winmanboo
 * @date 2023/12/22 15:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Reply对象", description = "回复表")
public class Reply extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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

    @ApiModelProperty("目标用户 id")
    private Long toUid;
}
