package com.winmanboo.bluebook.main.entity;

import java.io.Serial;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.winmanboo.bluebook.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Comments对象", description = "评论表")
public class Comment extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("主题 id")
    private Long topicId;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("评论用户 id")
    private Long fromUid;
}
