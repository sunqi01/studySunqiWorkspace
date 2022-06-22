package com.dbic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.dbic.jdbctest.dao.SunqiADao;
import com.dbic.jdbctest.entity.SunqiA;
import com.dbic.servlet.SpringServletService;
import com.dbic.springbean.HelloWorld;
import com.dbic.springbean.constructPourInto.Student;
import com.dbic.springbean.javacol.JavaCol; 
import com.dbic.springbean.setterPourInto.Teacher;

public class MainApp {

	public static void main(String[] args)
	throws Exception{
		
		//ClassPathXmlApplicationContext	加载类路径 ClassPath 下指定的 XML 配置文件，并完成 ApplicationContext 的实例化工作	
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext(String configLocation);
		//FileSystemXmlApplicationContext	加载指定的文件系统路径中指定的 XML 配置文件，
		//并完成 ApplicationContext 的实例化工作	ApplicationContext applicationContext = new FileSystemXmlApplicationContext(String configLocation);
		ApplicationContext context = new ClassPathXmlApplicationContext("/config/Bean.xml");
		HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
		helloWorld.getMessage();  
		
//		ApplicationContext context1 = new FileSystemXmlApplicationContext("D:\\sunqiWorkspace\\spring-web\\src\\main\\java\\config\\Bean.xml");
		HelloWorld helloWorld1 = context.getBean("helloWorld", HelloWorld.class);
		helloWorld1.getMessage(); 
		
		Student student = context.getBean("student", Student.class);
		student.say();
		
		Teacher teacher = context.getBean("teacher", Teacher.class);
		teacher.say();
		
		JavaCol javaCol =context.getBean("javaCol", JavaCol.class);
		javaCol.say();
		
		ApplicationContext context2 = new ClassPathXmlApplicationContext("/config/context.xml");
		SpringServletService springServletService = context2.getBean("springServletService", SpringServletService.class);
		System.out.println(springServletService.say("sunqi"));
		
		ApplicationContext context3 = new ClassPathXmlApplicationContext("/config/JDBC.xml");
		SunqiADao sunqiADao = context3.getBean("sunqiADao", SunqiADao.class);
		SunqiA sunqiA = new SunqiA();
		sunqiA.setUserId("22222");
		sunqiA.setUserName("李四");
		sunqiADao.add(sunqiA);
		
		
		
		
	}
}
