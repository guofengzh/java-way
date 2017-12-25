package com.avicit.tutorial.mybatis.student.mapper;

import com.avicit.tutorial.mybatis.student.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
	List<Student> getRecByName(Student student);
	List<Student> getRecByName_Id(Student student);
    void createTable() ;
    void dropTable() ;
}