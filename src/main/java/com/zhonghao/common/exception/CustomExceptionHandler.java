package com.zhonghao.common.exception;

import com.zhonghao.common.util.WebUtil;
import org.apache.commons.digester.annotations.utils.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import static org.springframework.core.annotation.AnnotationUtils.*;

/**
 * Created by zhonghao.han on 5/31/2018.
 * 定义全局的注解
 */
@Component
@ControllerAdvice
public class CustomExceptionHandler {
    @Resource
    private MappingJackson2JsonView mappingJackson2JsonView;

    @ExceptionHandler(value = Exception.class)
    public ModelAndView customException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler,Exception e) {
        ModelAndView mv = new ModelAndView();

        if (WebUtil.isAjaxRequest(request)||
                (handler!=null)&& findAnnotation(handler.getClass(),ResponseBody.class)!=null) {
            mv.setView(mappingJackson2JsonView);
            mv.addObject("status", -1);
            mv.addObject("desc", e.getMessage());
            mv.addObject("data",e);
            return mv;
        }
        mv.setViewName("50x");
        mv.addObject("status", -1);
        mv.addObject("desc", e.getMessage());
        mv.addObject("data",e);
        return mv;
    }

}
