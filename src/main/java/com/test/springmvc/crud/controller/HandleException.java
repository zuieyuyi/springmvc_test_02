package com.test.springmvc.crud.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler({RuntimeException.class})
    public ModelAndView handleRuntimeException(Exception ex){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception","其他运行时异常异常");
        return mv;
    }

    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception ex){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception",ex);
        return mv;
    }
}
