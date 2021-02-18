package com.dao;

import com.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    //查询student的所有数据
     List<Student> selectStudent();
     int insertStudent(Student student);
     List<Student> select3(@Param("sex") String sex,@Param("age") int age);

}
