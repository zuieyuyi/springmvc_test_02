package com.test.springmvc.crud.controller;

import com.test.springmvc.crud.bean.Student;
import com.test.springmvc.crud.bean.Teacher;
import com.test.springmvc.crud.dao.StudentDAO;
import com.test.springmvc.crud.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    TeacherDAO teacherDAO;

    @ModelAttribute
    public void getStudent(@RequestParam(value = "sno",required = false) String sno,Map<String,Object> map){
        if(sno != null){
            map.put("student",studentDAO.getStuBySno(sno));
        }
    }

    /**
     * 更新学生数据操作
     */
    @RequestMapping(value = "/stu",method = RequestMethod.PUT)
    public String update(Student student){
        studentDAO.saveStu(student);
        return "redirect:/stus";
    }

    /**
     * 进入编辑学生界面
     */
    @RequestMapping(value = "/stu/{sno}",method = RequestMethod.GET)
    public String input(@PathVariable("sno") String sno,Map<String,Object> map){
        map.put("student",studentDAO.getStuBySno(sno));
        map.put("teachers",teacherDAO.getTeachers());
        return "input";
    }

    /**
     * 所有学生列表
     */
    @RequestMapping("/stus")
    public String list(Map<String, Object> map){
        map.put("students",studentDAO.getAllStu());
        return "list";
    }

    /**
     * 进入添加页面
     */
    @RequestMapping(value="/stu",method = RequestMethod.GET)
    public String input(Map<String,Object> map){
        map.put("teachers",teacherDAO.getTeachers());
        map.put("student",new Student());
        return "input";
    }

    /**
     * 添加学生操作
     *
     * @BindingResult 类型转换失败时会将失败原因放入其中
     */
    @RequestMapping(value="/stu",method = RequestMethod.POST)
    public String insertStu(@Valid Student student, BindingResult bindingResult,Map<String,Object> map){
        System.out.println(student);

        if(bindingResult.getErrorCount() > 0){
            System.out.println("出错了");
            for (FieldError error:bindingResult.getFieldErrors()){
                System.out.println(error.getField() +":" +error.getDefaultMessage());
            }
            //若验证出错则转向指定的页面
            map.put("teachers",teacherDAO.getTeachers());
            return "input";
        }

        studentDAO.addStu(student);
        return "redirect:/stus";
    }

    /**
     * 删除学生操作
     */
    @RequestMapping(value = "/stu/{sno}",method = RequestMethod.DELETE)
    public String deleteStu(@PathVariable("sno") String sno){
        studentDAO.deleteStuBySno(sno);
        return "redirect:/stus";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        //设置在表单对javabean进行赋值时那个值不进行赋值
//        binder.setDisallowedFields("name");
//    }

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
}
