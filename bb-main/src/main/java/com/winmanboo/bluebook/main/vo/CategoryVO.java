package com.winmanboo.bluebook.main.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author winmanboo
 * @date 2023/12/13 22:03
 */
@Data
public class CategoryVO {
    @ApiModelProperty("类目id")
    private Integer id;

    @ApiModelProperty("类目名称")
    private String name;
}
