package com.winmanboo.bluebook.uaa.point;

import com.winmanboo.bluebook.result.Result;
import com.winmanboo.bluebook.result.UserResultStatus;
import com.winmanboo.bluebook.utils.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author winmanboo
 * @date 2023/5/24 19:05
 */
@Slf4j
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        ResponseUtil.out(response, Result.fail(UserResultStatus.A0201));
    }
}
