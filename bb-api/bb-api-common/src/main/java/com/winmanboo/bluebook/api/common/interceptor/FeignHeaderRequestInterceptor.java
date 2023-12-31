package com.winmanboo.bluebook.api.common.interceptor;

import com.winmanboo.bluebook.constants.OAuth2Constant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;


/**
 * 该拦截器对 Authorization 请求头透传
 *
 * @author winmanboo
 * @date 2024/1/4 18:30
 */
@Component
public class FeignHeaderRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        String authorizationHeader = getAuthorizationHeader();
        if (!Objects.isNull(authorizationHeader)) {
            template.header(OAuth2Constant.AUTHORIZATION_HEADER, authorizationHeader);
        }
    }

    private static String getAuthorizationHeader() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(requestAttributes)) {
            return null;
        }
        HttpServletRequest request = requestAttributes.getRequest();
        return request.getHeader(OAuth2Constant.AUTHORIZATION_HEADER);
    }
}
