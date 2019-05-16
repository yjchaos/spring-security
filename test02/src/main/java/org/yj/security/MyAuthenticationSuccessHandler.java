package org.yj.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yaojun
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

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


    /**
     *
     * @param request
     * @param response
     * @param authentication 登陆成功后的信息
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map<String, Object> result = new HashMap();
        result.put("success", true);
        String json = objectMapper.writeValueAsString(result);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
