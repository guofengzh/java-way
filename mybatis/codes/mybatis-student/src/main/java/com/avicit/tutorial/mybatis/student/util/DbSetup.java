package com.avicit.tutorial.mybatis.student.util;

import org.apache.ibatis.session.SqlSession;

public class DbSetup {
    public static void dbInit(SqlSession session) {
        try {
            session.insert("dropTable");
        } catch (Exception t ) {
            System.out.println( t.getMessage()) ;
        }
        try {
            session.insert("createTable");
        } catch (Exception t ) {
            System.out.println( t.getMessage()) ;
        }
    }
}
