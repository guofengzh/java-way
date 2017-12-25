package com.avicit.tutorial.mybatis.student.mapper;

import com.avicit.tutorial.mybatis.student.domain.Student;
import com.avicit.tutorial.mybatis.student.util.DbSetup;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MainM {
    private static  SqlSessionFactory sqlSessionFactory ;
    public static void main(String[] args ) throws IOException {

        Reader reader = Resources.getResourceAsReader("myabatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = sqlSessionFactory.openSession();

        DbSetup.dbInit(session);
        session.commit();
        session.close();

        insert() ;
        select();
        update() ;
        delete();
    }

    private static void insert() {
        SqlSession session = sqlSessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        //Create a new student object
        Student student = new Student();

        //Set the values
        student.setName("zara");
        student.setBranch("EEE");
        student.setEmail("aa@domain.com");
        student.setPercentage(90);
        student.setPhone(123412341);

        //Insert student data
        mapper.insert(student);
        System.out.println("record inserted successfully");
        session.commit();
        session.close();

    }

    private static void update() {
        SqlSession session = sqlSessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        //select a particular student using id
        Student student = mapper.getById(10000);
        System.out.println("Current details of the student are "+student.toString());

        //Set new values to the mail and phone number of the student
        student.setEmail("Shyam123@yahoo.com");
        student.setPhone(984802233);

        //Update the student record
        mapper.update(student);
        System.out.println("Record updated successfully");
        session.commit();
        session.close();
    }

    private static void select() {
        SqlSession session = sqlSessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        //select contact all contacts
        List<Student> student = mapper.getAll();

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

    private static void delete() {
        SqlSession session = sqlSessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        mapper.deleteById(10000);
        System.out.println("record deleted successfully");
        session.commit();
        session.close();
    }
}
