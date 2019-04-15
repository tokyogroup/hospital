package com.azeroth.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azeroth.bean.Patients;
import com.azeroth.bean.Registration;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.PatientsDao;
import com.azeroth.dao.RegistrationDao;
import com.azeroth.dao.UserinfosDao;
import com.azeroth.daoimpl.PatientsDaoImpl;
import com.azeroth.daoimpl.RegistrationDaoImpl;
import com.azeroth.daoimpl.UserinfosDaoImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	     RegistrationDao registrationDaoImpl =new RegistrationDaoImpl();
	     
    	public String QueryRegistration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		String condition=null;
    		String pi_id=req.getParameter("pi_id");
    		String pi_name=req.getParameter("pi_name");
    		String s_id=req.getParameter("s_id");
    		if(!"".equals(pi_id) && pi_id!=null) {
    			condition = condition + " and pi_id = '"+pi_id+"'";
    		}
    		if(!"".equals(pi_name) && pi_name!=null) {
    			condition = condition + " and pi_name = '"+pi_name+"'";
    		}
    		if(!"".equals(s_id) && s_id!=null) {
    			condition = condition + " and s_id = '"+s_id+"'";
    		}
    		
    		List<Registration> registrationList= registrationDaoImpl.queryRigistration(condition);
    		req.getSession().setAttribute("registrationList", registrationList);
    		return"html/Guahao/guahao.jsp";
    	}
        public String addRegistration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		System.out.println("-----addmethod----");
        	UserinfosDao userDaoImpl = new UserinfosDaoImpl();
        	String rg_id = req.getParameter("rg_id"); 
    		String pi_id= req.getParameter("pi_id");  
    		String u_id= req.getParameter("u_id");    
    		String d_id= req.getParameter("d_id");     //医生id
    		Userinfos userinfos = userDaoImpl.userFindByUid(d_id);
    		Double rg_price= Double.parseDouble(req.getParameter("rg_price"));
    		String rg_date= req.getParameter("rg_date");   
    		int rg_status =0;
        	Registration registration = new Registration(rg_id, pi_id, u_id, userinfos, rg_price, rg_date, rg_status);
        	registrationDaoImpl.addRegistration(registration);
    		return"html/Guahao/guahao.jsp";
    	}
       public String delRegistration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	   String rg_id= req.getParameter("rg_id");
    	   registrationDaoImpl.delRegistration(rg_id);
    	   return null;
       }
       }
