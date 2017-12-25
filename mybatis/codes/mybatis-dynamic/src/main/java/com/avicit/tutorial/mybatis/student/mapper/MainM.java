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
        
        session = sqlSessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student stud = new Student();
        stud.setName("Haha");
        
        //select contact all contacts		
        //List<Student> student = session.selectList("getRecByName",stud);
        
        stud.setId(1);
        List<Student> student = mapper.getRecByName_Id(stud);
            
        for(Student st : student ){    	  
      	   	  
           System.out.println("++++++++++++++details of the student named Mohammad are "+"+++++++++++++++++++" );
      	  
           System.out.println("Id :  "+st.getId());
           System.out.println("Name :  "+st.getName());
           System.out.println("Branch :  "+st.getBranch());
           System.out.println("Percentage :  "+st.getPercentage());         
           System.out.println("Email :  "+st.getEmail());        
           System.out.println("Phone :  "+st.getPhone());    	  
      	 
        }     
        
        System.out.println("Records Read Successfully ");          
        session.commit();   
        session.close();		
    }
}
