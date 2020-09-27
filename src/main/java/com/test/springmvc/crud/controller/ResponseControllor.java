package com.test.springmvc.crud.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@Controller
public class ResponseControllor {

    /**
     * 文件下载效果
     */
    @ResponseBody
    @RequestMapping("testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession httpSession) throws IOException {
        byte[] body = null;
        ServletContext servletContext = httpSession.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition","attachment;filename=abc.txt");

        HttpStatus httpStatus = HttpStatus.OK;

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(body,httpHeaders,httpStatus);

        return responseEntity;
    }

    /**
     * @ResponseBody 目标方法的返回值
     * @RequestBody 目标方法的入参
     */
    @ResponseBody
    @RequestMapping("testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body){
        System.out.println(body);
        return "Hello world" + new Date();
    }
}
