package com.test.springmvc.crud.dao;

import com.test.springmvc.crud.bean.Teacher;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TeacherDAO {
    private static Map<String, Teacher> teacherMap = null;

    static{
        teacherMap = new HashMap<>();

        teacherMap.put("T001",new Teacher("T001","老师1",55));
        teacherMap.put("T002",new Teacher("T002","老师2",53));
        teacherMap.put("T003",new Teacher("T003","老师3",52));
        teacherMap.put("T004",new Teacher("T004","老师4",51));
    }

    public Collection<Teacher> getTeachers(){
        return teacherMap.values();
    }

    public Teacher getTeacherByNo(String no){
        return teacherMap.get(no);
    }
}
