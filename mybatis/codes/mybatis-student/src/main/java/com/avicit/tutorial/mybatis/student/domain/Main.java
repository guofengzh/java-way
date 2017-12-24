package com.avicit.tutorial.mybatis.student.domain;

import com.avicit.tutorial.mybatis.student.util.DbSetup;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main {
    private static SqlSessionFactory sqlSessionFactory ;
    public static void main(String[] args ) throws Exception {

        Reader reader = Resources.getResourceAsReader("myabatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = sqlSessionFactory.openSession();
        DbSetup.dbInit(session);
        session.commit();
        session.close();

        insert() ;
        selectAll();
        update() ;
        delete();

    }

    public static void insert() {
        SqlSession session = sqlSessionFactory.openSession();

        //Create a new student object
        Student student = new Student("Mohammad","It", 80, 984803322, "Mohammad@gmail.com" );

        //Insert student data
        session.insert("insert", student);
        System.out.println("record inserted successfully");
        session.commit();
        session.close();
    }

    public static void update() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();

        //select a particular student using id
        Student student = (Student) session.selectOne("getById", 10000);
        System.out.println("Current details of the student are" );
        System.out.println(student.toString());

        //Set new values to the mail and phone number of the student
        student.setEmail("mohamad123@yahoo.com");
        student.setPhone(90000000);

        //Update the student record
        session.update("update",student);
        System.out.println("Record updated successfully");
        session.commit();
        session.close();
    }

    public static void delete() {
        SqlSession session = sqlSessionFactory.openSession();

        //Delete operation
        session.delete("deleteById", 10000);
        session.commit();
        session.close();
        System.out.println("Record deleted successfully");
    }

    public static void selectAll() {
        SqlSession session = sqlSessionFactory.openSession();

        //select contact all contacts
        List<Student> student = session.selectList("getAll", Student.class);

        for(Student st : student ){
            System.out.println(st.getId());
            System.out.println(st.getName());
            System.out.println(st.getBranch());
            System.out.println(st.getPercentage());
            System.out.println(st.getEmail());
            System.out.println(st.getPhone());
        }

        System.out.println("Records Read Successfully ");
        session.commit();
        session.close();
    }
}
