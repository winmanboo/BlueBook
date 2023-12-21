package com.winmanboo.bluebook.uaa.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码认证异常
 *
 * @author winmanboo
 * @date 2023/7/6 20:29
 */
public class CaptchaAuthenticationException extends AuthenticationException {
    public CaptchaAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CaptchaAuthenticationException(String msg) {
        super(msg);
    }
}
