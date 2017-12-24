package com.avicit.tutorial.mybatis.student.util;

import com.avicit.tutorial.mybatis.student.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;

public class DbSetup {
    public static void dbInit(SqlSession session) {
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        try {
            mapper.dropTable();
        } catch (Exception t ) {
            System.out.println( t.getMessage()) ;
        }
        try {
           mapper.createTable();
        } catch (Exception t ) {
            System.out.println( t.getMessage()) ;
        }
    }
}
