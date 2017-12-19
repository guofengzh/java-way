package servlet.basic.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	String url = ctx.getInitParameter("url");
    	String u = ctx.getInitParameter("user");
    	String p = ctx.getInitParameter("pwd");
    	
    	//create database connection from init parameters and set it to context
    	ConnectionManager dbManager = new ConnectionManager(url, u, p);
    	ctx.setAttribute("connectionManager", dbManager);
    	System.out.println("Database connection initialized for Application.");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	ServletContext ctx = servletContextEvent.getServletContext();
    	System.out.println("Database connection closed for Application.");
    }
}