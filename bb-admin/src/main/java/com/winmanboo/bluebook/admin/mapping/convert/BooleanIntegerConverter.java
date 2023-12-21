package com.winmanboo.bluebook.admin.mapping.convert;

import com.winmanboo.bluebook.utils.BooleanNumUtil;
import org.springframework.stereotype.Component;

/**
 * @author winmanboo
 * @date 2023/7/15 16:16
 */
@Component
public class BooleanIntegerConverter {
    public Boolean toBoolean(Integer alwaysShow) {
        return BooleanNumUtil.isTrue(alwaysShow);
    }

    public Integer toInteger(Boolean alwaysShow) {
        return (alwaysShow != null && alwaysShow) ? 1 : 0;
    }
}
