package com.project.entity;

import com.project.dao.StudentDao;
import com.project.dao.UserDao;
import com.project.util.MybatisUtil;
import com.project.dao.TimeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
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
    @Test
    public void testTime(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        TimeDao timeDao=sqlSession.getMapper(TimeDao.class);
        TimeTest timeTest=new TimeTest(LocalDateTime.now());
        int result=timeDao.insertTime(timeTest);
        System.out.println("insert结果： "+result);
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void testUser(){
        UserDao userDao=MybatisUtil.getSqlSession().getMapper(UserDao.class);
        List<User> list=userDao.selectTest();
        System.out.println(list);
    }
    @Test
    public void testLogin(){
        String email="123@qq.com";
        String password="123";
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        UserDao userDao= sqlSession.getMapper(UserDao.class);
        User user= userDao.login(email);
        System.out.println(user);

    }
    @Test
    public void testInsert2(){
        String id="2";
        String fileRepositoryId="2";
        String userName="Lucy";
        String email="1234@com";
        String password="1234";
        LocalDateTime time= LocalDateTime.now();
        String avatar=null;
        String role="1";
        User user=new User();
        user.setId(id);
        user.setFileRepositoryId(fileRepositoryId);
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRegisterTime(time);
        user.setRole(role);
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        UserDao userDao= sqlSession.getMapper(UserDao.class);
        int result=userDao.insertUser(user);
        System.out.println(result);
        sqlSession.commit();
    }

}
