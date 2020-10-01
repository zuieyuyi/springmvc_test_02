package com.test.springmvc.crud.controller;

import com.test.springmvc.crud.bean.Student;
import com.test.springmvc.crud.dao.StudentDAO;
import com.test.springmvc.crud.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Locale;

@Controller
public class StudentServiceConvererController {
    @Autowired
    StudentDAO studentDAO;

    @Autowired
    TeacherDAO teacherDAO;

    /**
     * 用于获取国际化资源文件对应的消息
     */
    @Autowired
    ResourceBundleMessageSource messageSource;

    @RequestMapping("gotoConverer")
    public String gotoConvererPage(){
        return "testConvererPage";
    }

    @RequestMapping(value="/convererTest",method = RequestMethod.POST)
    public String testConverer(@RequestParam("student") Student student){
        System.out.println(student);
        studentDAO.addStu(student);
        return "redirect:/stus";
    }

    @ResponseBody
    @RequestMapping("testJson")
    public Collection<Student> testJson(){
        return studentDAO.getAllStu();
    }

    /**
     * 通过超链接修改locale，国际化
     */
    @RequestMapping("/i18n")
    public String testI18n(Locale locale){
        String message = messageSource.getMessage("i18n.user",null,locale);
        System.out.println(message);
        return "i18n";
    }

    /**
     * 文件上传
     */
    @RequestMapping("testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("desc:" + desc);
        //获取文件原始的名字
        System.out.println("OriginalFilename:" + file.getOriginalFilename());
        //获取文件所对应的输入流
        System.out.println("InputStream:" + file.getInputStream());
        return "success";
    }

    /**
     * 多文件上传
     */
    @RequestMapping("testFilesUpload")
    public String testFilesUpload(@RequestParam("files") MultipartFile[] files) throws IOException {
        for (MultipartFile file:files){
            System.out.println("OriginalFilename:" + file.getOriginalFilename());
            System.out.println("InputStream:" + file.getInputStream());
        }
        return "success";
    }

}
