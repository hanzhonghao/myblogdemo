package com.zhonghao.common.security;

import com.zhonghao.common.annotation.Security;
import com.zhonghao.common.constant.UserConstants;
import com.zhonghao.common.exception.CustomSecurityException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.zhonghao.common.enums.ErrorEnum.NOT_LOGIN;

/**
 * Created by zhonghao.han on 6/1/2018.
 * 该拦截器，会拦截指定的URL表达式，是用来做权限管理的。
 */
@Component
public class SecurityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Security security = handlerMethod.getMethodAnnotation(Security.class);
            if (security == null) {
                return true;
            }

            // 需要校验是否登录
            IUser user = (IUser)request.getSession().getAttribute(UserConstants.SESSION_USER);
            if(user == null) {
                throw new CustomSecurityException(NOT_LOGIN);
            }
            SessionUserContext.put(user);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {

    }
}
