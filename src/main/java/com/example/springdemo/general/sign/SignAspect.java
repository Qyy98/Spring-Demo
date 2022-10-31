package com.example.springdemo.general.sign;

import com.example.springdemo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

/**
 * SignAspect
 *
 * @Description 接口签名验证切片
 * @Author QianYiyu
 * @Date 2022/08/28 20:11
 */
@Component
@Aspect
@Slf4j
public class SignAspect {
    @Pointcut("@annotation(com.example.springdemo.general.sign.Signature)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        // FIXME: 三种参数传递方式正确取参。将三种传递方式里的参数都转化为key1=value1&key2=value2的形式。
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        // @RequestBody
        String bodyParam = null;
        if (request instanceof ContentCachingRequestWrapper) {
            bodyParam = new String(((ContentCachingRequestWrapper) request).getContentAsByteArray(), StandardCharsets.UTF_8);
        }

        // @RequestParam
        Map<String, String[]> requestParameterMap = request.getParameterMap();

        // @PathVariable
        String[] paths = null;
        ServletWebRequest webRequest = new ServletWebRequest(request, null);
        Map<String, String> uriTemplateVars = (Map<String, String>) webRequest.getAttribute(
                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
        if (!CollectionUtils.isEmpty(uriTemplateVars)) {
            paths = uriTemplateVars.values().toArray(new String[0]);
        }
        log.info("生成方法签名：" + SignUtil.sign(bodyParam, requestParameterMap, paths));
    }
}
