package com.example.springdemo.general.sign;

import lombok.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * RequestCachingFilter
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/28 20:08
 */
public class RequestCachingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        boolean isFirstRequest = !isAsyncDispatch(request);
        HttpServletRequest requestWrapper = request;
        if (isFirstRequest && !(request instanceof ContentCachingRequestWrapper)) {
            requestWrapper = new ContentCachingRequestWrapper(request);
        }
        try {
            filterChain.doFilter(requestWrapper, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
