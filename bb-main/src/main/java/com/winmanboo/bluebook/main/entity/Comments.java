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
public class Comments extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("帖子id")
    private Long postId;

    @ApiModelProperty("用户id")
    private Long uid;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户头像")
    private String userAvatar;

    @ApiModelProperty("点赞数量")
    private Integer likesNumber;

    @ApiModelProperty("父评论id,0 表示这个评论是根评论")
    private Long parentId;

    @ApiModelProperty("被回复者的id")
    private Long replyUid;

    @ApiModelProperty("被回复者的用户名")
    private Long replyUsername;

    @ApiModelProperty("省份")
    private String province;

    @ApiModelProperty("ip")
    private String ip;

    @ApiModelProperty("0:不是作者 1:是作者")
    private Integer isAuthor;
}
