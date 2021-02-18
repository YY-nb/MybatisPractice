package com.domain;

import com.dao.StudentDao;
import com.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void testInsert() throws IOException {
        String config="mybatis.xml";
        InputStream inputStream= Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory= builder.build(inputStream);
        SqlSession sqlSession=factory.openSession();
        String sqlId="com.dao.StudentDao.insertStudent";
        Student student=new Student(0,"Lisa","女",18,"二班");
        int result=sqlSession.insert(sqlId,student);
        System.out.println("insert结果： "+result);
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void testSelect(){

        SqlSession sqlSession= MybatisUtil.getSqlSession();
        String sqlId="com.dao.StudentDao.selectStudent";
        List<Student> studentList=sqlSession.selectList(sqlId);
        studentList.forEach(student -> System.out.println(student));
        sqlSession.close();
    }
    @Test
    public void testSelect2(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库操作
        List<Student> studentList= dao.selectStudent();
        for(Student student:studentList){
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public  void testSelect3(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao =sqlSession.getMapper(StudentDao.class);
        List<Student> studentList= dao.select3("女",19);
        for(Student student:studentList){
            System.out.println(student);
        }
        sqlSession.close();
    }
}
