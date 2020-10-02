package com.test.springmvc.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * -@ResponseStatus
 *  value返回的状态码
 *  reason返回的异常原因
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "测试异常对象@ResponseStatus注释,我的异常")
public class MyException extends RuntimeException{
}
