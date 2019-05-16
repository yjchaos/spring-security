package org.yj.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yaojun
 */
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {

    // ~ Static fields/initializers
    // =====================================================================================

    // ~ Instance fields
    // ================================================================================================

    /**
     * ObjectMapper:jackson框架工具类，用于转换对象为json字符串
     */
    private ObjectMapper objectMapper = new ObjectMapper();

    // ~ Constructors
    // ===================================================================================================

    // ~ Methods
    // ========================================================================================================


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Map<String, Object> result = new HashMap();
        result.put("success", false);
        if (exception != null) {
            result.put("errorMsg", exception.getMessage());
        }
        String json = objectMapper.writeValueAsString(result);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
