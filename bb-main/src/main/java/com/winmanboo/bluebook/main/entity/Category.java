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
 * 类目表
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Category对象", description = "类目表")
public class Category extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("类目id")
    private Integer id;

    @ApiModelProperty("类目名称")
    private String name;
}
