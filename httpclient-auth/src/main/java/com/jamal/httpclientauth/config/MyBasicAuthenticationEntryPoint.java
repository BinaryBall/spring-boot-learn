package com.jamal.httpclientauth.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author xiaoxiang
 * @title: MyBasicAuthenticationEntryPoint
 * @projectName httpclient-auth
 * @description: TODO
 * @date 2019/9/313:49
 */
@Component
public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter printWriter = new PrintWriter(response.getOutputStream());
        printWriter.write("Http Status 401: " + authException.getLocalizedMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("developlee");
        super.afterPropertiesSet();
    }
}
