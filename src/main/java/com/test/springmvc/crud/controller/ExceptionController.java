package com.test.springmvc.crud.controller;

import com.test.springmvc.crud.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
    /**
     * 1、在 @ExceptionHandler 方法的入参中可以加入 Exception 类型的参数，该参数即对应发生的异常对象
     * 2、@ExceptionHandler 方法的入参不能传入Map。若希望把一场信息传导到页面上，需要使用 ModelAndView 作为返回值
     * 3、@ExceptionHandler 方法标记的异常优先级问题
     *      精度越高优先级越高
     *      例如：ArithmeticException和RuntimeException，抛出异常为ArithmeticException ，优先执行被@ExceptionHandler({ArithmeticException.class})修饰的方法
     * 4、@ControllerAdvice 如果在当前Handler中找不到 @ExceptionHandler 修饰的方法来处理当前出现的异常
     * ，则将会去@ControllerAdvice 标记的类中查找 @ExceptionHandler 修饰的方法来处理异常。
     */
//    @ExceptionHandler({ArithmeticException.class})
//    public ModelAndView handleArithmeticException(Exception ex){
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("exception",ex);
//        return mv;
//    }

    @RequestMapping("testExceptionHandler")
    public String testExceptionHandler(@RequestParam("i") Integer i){
        System.out.println("result:"+10/i);
        return "success";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "测试方法@ResponseStatus注解")
    @RequestMapping("testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver(@RequestParam("i") Integer i){
        if (i==13){
            throw new MyException();
        }
        System.out.println("testResponseStatusExceptionResolver");
        return "success";
    }

    @RequestMapping("testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(@RequestParam("i") Integer i){
        String[] vals = new String[10];
        System.out.println(vals[i]);
        return "success";
    }
}
