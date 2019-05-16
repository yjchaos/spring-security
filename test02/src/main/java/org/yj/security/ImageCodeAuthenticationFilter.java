package org.yj.security;

import lombok.Setter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yaojun
 */
public class ImageCodeAuthenticationFilter extends OncePerRequestFilter {

    // ~ Static fields/initializers
    // =====================================================================================

    // ~ Instance fields
    // ================================================================================================

    @Setter
    private AuthenticationFailureHandler authenticationFailureHandler;

    // ~ Constructors
    // ===================================================================================================

    // ~ Methods
    // ========================================================================================================


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 判断当前请求是否为登陆请求
        if (httpServletRequest.getRequestURI().contains("/securityLogin")) {
            try {
                // 获取用户输入验证码
                String imageCode = httpServletRequest.getParameter("imageCode");

                // 获取系统生产的验证码
                String key = (String) httpServletRequest.getSession().getAttribute("key");

                if (imageCode == null || imageCode.trim().isEmpty()) {
                    throw new ImageCodeException("验证码必须输入");
                }

                if (!imageCode.trim().equals(key.trim())) {
                    throw new ImageCodeException("验证码不一致");
                }
            } catch (AuthenticationException e) {
                // 交给AuthenticationFailureHandler处理
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            }

        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
