package com.azeroth.servlet;

import java.util.List;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.azeroth.bean.Section;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.SectionDao;
import com.azeroth.dao.UserinfosDao;
import com.azeroth.daoimpl.SectionDaoimpl;
import com.azeroth.daoimpl.UserinfosDaoimpl;

/**
 * Application Lifecycle Listener implementation class InitialListener
 *
 */
@WebListener
public class InitialListener implements ServletContextListener, ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public InitialListener() {
        // TODO Auto-generated constructor stub
    }


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
       SectionDao secDaoImpl = new SectionDaoimpl();
       List<Section> sectionList=secDaoImpl.sectionFindAll();
       sce.getServletContext().setAttribute("sectionList", sectionList);
       UserinfosDao userDaoImpl = new UserinfosDaoimpl();
       List<Userinfos> userinfosList = userDaoImpl.userFindAll();
       sce.getServletContext().setAttribute("userinfosList", sectionList);
    }


	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
