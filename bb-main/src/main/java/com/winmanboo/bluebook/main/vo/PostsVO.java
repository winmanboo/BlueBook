package com.winmanboo.bluebook.main.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author winmanboo
 * @date 2023/12/13 22:26
 */
@Data
public class PostsVO {
    private Long id;

    @ApiModelProperty("封面")
    private String banners;

    @ApiModelProperty("主题")
    private String subject;

    @ApiModelProperty("点赞数量")
    private Integer likesNumber;

    @ApiModelProperty("发布者用户名")
    private String postUsername;

    @ApiModelProperty("发布者头像")
    private String postAvatar;
}
