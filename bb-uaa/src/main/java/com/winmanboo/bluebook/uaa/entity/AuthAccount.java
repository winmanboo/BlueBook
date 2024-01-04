package com.winmanboo.bluebook.uaa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.winmanboo.bluebook.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author winmanboo
 * @date 2023/12/22 21:43
 */
@Data
@TableName(value = "auth_account")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "AuthAccount对象", description = "授权账户表")
public class AuthAccount extends BaseEntity {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户 id")
    private Long userId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("创建时的 ip 地址")
    private String createIp;

    @ApiModelProperty("用户状态 0：禁用 1：启用 -1：删除")
    private Integer status;

    @ApiModelProperty("系统类型")
    private Integer sysType;

    @ApiModelProperty("租户 id")
    private Long tenantId;

    @ApiModelProperty("是否是管理员")
    private Integer isAdmin;
}
