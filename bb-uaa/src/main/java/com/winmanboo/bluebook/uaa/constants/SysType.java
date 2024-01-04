package com.winmanboo.bluebook.uaa.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author winmanboo
 * @date 2023/12/22 21:47
 */
@Getter
@RequiredArgsConstructor
public enum SysType {
    /**
     * 普通用户
     */
    ORDINARY(0),
    /**
     * 管理端
     */
    ADMIN(1);

    private final Integer value;
}
