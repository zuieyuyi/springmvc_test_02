package com.test.springmvc.crud.dao;

import com.test.springmvc.crud.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class StudentDAO {
    @Autowired
    private static TeacherDAO teacherDAO;

    private static Map<String, Student> studentMap = null;

    static{
        studentMap = new HashMap<>();

        studentMap.put("21190601",new Student("T001","21190601","张三",12,98));
        studentMap.put("21190602",new Student("T001","21190602","李四",11,65));
        studentMap.put("21190603",new Student("T002","21190603","王五",15,87));
        studentMap.put("21190604",new Student("T003","21190604","赵六",13,92));
    }

    public Collection<Student> getAllStu(){
        return studentMap.values();
    }

    public void addStu(Student student){
        student.setSno("211906"+studentMap.size());
        studentMap.put(student.getSno(),student);
    }

    public Student getStuBySno(String sno){
        return studentMap.get(sno);
    }

    public void deleteStuBySno(String Sno){
        studentMap.remove(Sno);
    }

    public void saveStu(Student student){
        studentMap.put(student.getSno(),student);
    }
}
