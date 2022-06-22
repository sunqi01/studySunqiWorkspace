package com.dbic.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dbic.jdbctest.dao.SunqiADao;
import com.dbic.jdbctest.entity.SunqiA;

public class SpringServlet extends HttpServlet{
	
	SpringServletService springServletService;
	
	SunqiADao sunqiADao;

	public void init()
	{
		ServletContext servletContext =  this.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		setSpringServletService((SpringServletService)wac.getBean("springServletService"));
		setSunqiADao((SunqiADao)wac.getBean("sunqiADao"));
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		
		System.out.println(req.getParameter("name"));
		System.out.println(springServletService.say(req.getParameter("name")));
		SunqiA sunqiA = new SunqiA();
		sunqiA.setUserId(req.getParameter("id"));
		sunqiA.setUserName(req.getParameter("name"));
		
		sunqiADao.add(sunqiA);
		
//		resp.getWriter().write(springServletService.say(req.getParameter("name")));
//		resp.getWriter().flush();
	}

	public SpringServletService getSpringServletService() {
		return springServletService;
	}

	public void setSpringServletService(SpringServletService springServletService) {
		this.springServletService = springServletService;
	}

	public SunqiADao getSunqiADao() {
		return sunqiADao;
	}

	public void setSunqiADao(SunqiADao sunqiADao) {
		this.sunqiADao = sunqiADao;
	}
}
