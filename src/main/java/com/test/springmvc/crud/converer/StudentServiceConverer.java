package com.test.springmvc.crud.converer;

import com.test.springmvc.crud.bean.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceConverer implements Converter<String, Student> {
    /**
     * 将输入数据转化为学生类
     */
    @Override
    public Student convert(String source) {
        if(source != null){
            String[] vals = source.split("-");
//            T003-2116062-王五-11-66
            if(vals.length == 5){
                String teacherno = vals[0];
                String sno = vals[1];
                String name = vals[2];
                Integer age = Integer.parseInt(vals[3]);
                Integer mark = Integer.parseInt(vals[4]);

                Student student = new Student(teacherno,sno,name,age,mark);
                return student;
            }
        }
        return null;
    }
}
