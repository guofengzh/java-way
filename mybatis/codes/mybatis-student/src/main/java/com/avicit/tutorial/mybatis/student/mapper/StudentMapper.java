package com.avicit.tutorial.mybatis.student.mapper;

import com.avicit.tutorial.mybatis.student.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    Student getById(int id);
    List<Student> getAll();
    void update(Student student);
    void deleteById(int id);
    void insert(Student student);
    void createTable() ;
    void dropTable() ;
}