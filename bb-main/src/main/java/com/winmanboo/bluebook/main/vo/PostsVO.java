package com.winmanboo.bluebook.main.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author winmanboo
 * @date 2023/12/13 22:26
 */
@Data
public class PostsVO {
    private Long id;

    @ApiModelProperty("描述信息")
    private String information;

    @ApiModelProperty("图片banner以逗号分割,最多 9 张图片")
    private String banners;

    @ApiModelProperty("短视频地址")
    private String video;

    @ApiModelProperty("主题")
    private String subject;

    @ApiModelProperty("类型 0:图文形式 1:视频形式")
    private Integer type;

    @ApiModelProperty("评论数量")
    private Integer commentsNumber;

    @ApiModelProperty("点赞数量")
    private Integer likesNumber;

    @ApiModelProperty("收藏数量")
    private Integer collectsNumber;

    @ApiModelProperty("发布人id")
    private Long postUid;

    @ApiModelProperty("省份")
    private String province;

    @ApiModelProperty("发布ip")
    private String postIp;

    @ApiModelProperty("话题id")
    private Long talkId;

    @ApiModelProperty("地点")
    private String site;

    @ApiModelProperty("权限类型 0:公开可见 1:仅自己可见")
    private Integer permissionType;

    @ApiModelProperty("发布类型 0:立即发布 1:定时发布")
    private Integer postType;

    @ApiModelProperty("发布时间（如果发布类型是定时发布需要用户手动传递）")
    private LocalDateTime postedTime;

    @ApiModelProperty("置顶评论的id,默认为-1表示没有置顶评论")
    private Long topCommentId;

    @ApiModelProperty("所属类别id")
    private Long categoryId;
}
