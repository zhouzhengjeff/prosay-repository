package com.prosay.oa.web.resolver;

import com.prosay.oa.exception.SsmException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OaExceptionHandlerResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        String message = "您出错了";
        if (ex != null) {
            if (ex instanceof SsmException) {
                SsmException ssmException = (SsmException) ex;
                message = ssmException.getMessage();
            } else if (ex instanceof IllegalArgumentException) {
                IllegalArgumentException illegalArgumentException = (IllegalArgumentException) ex;
                message = illegalArgumentException.getMessage();
            }

            modelAndView.addObject("message", message);
            modelAndView.setViewName("common/error");
        }
        return modelAndView;
    }
}
