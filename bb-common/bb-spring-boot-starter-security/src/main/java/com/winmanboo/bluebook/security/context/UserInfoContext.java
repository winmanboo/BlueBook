package com.winmanboo.bluebook.security.context;

import com.winmanboo.bluebook.exception.JiamingException;
import com.winmanboo.bluebook.security.domain.UserInfo;
import lombok.experimental.UtilityClass;

import java.util.Objects;

/**
 * 存储当前线程的用户信息
 *
 * @author winmanboo
 * @date 2023/6/8 19:53
 */
@UtilityClass
public class UserInfoContext {
    private static final ThreadLocal<UserInfo> USER_INFO_THREAD_LOCAL = new ThreadLocal<>();

    public UserInfo get() {
        UserInfo userInfo = USER_INFO_THREAD_LOCAL.get();
        if (Objects.isNull(userInfo)) {
            throw new JiamingException("用户信息异常");
        }
        return userInfo;
    }

    public void set(UserInfo userInfo) {
        USER_INFO_THREAD_LOCAL.set(userInfo);
    }

    public void clear() {
        UserInfo userInfo = USER_INFO_THREAD_LOCAL.get();

        if (Objects.nonNull(userInfo)) {
            USER_INFO_THREAD_LOCAL.remove();
        }
    }
}
