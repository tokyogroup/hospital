package com.azeroth.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.azeroth.daoimpl.PatientsDaoimpl;
import com.azeroth.daoimpl.RegistrationDaoImpl;
import com.azeroth.daoimpl.UserinfosDaoimpl;
import com.azeroth.utils.UUIDUtil;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	     RegistrationDao registrationDaoImpl =new RegistrationDaoImpl();
	     PatientsDao patientsDaoimpl = new PatientsDaoimpl();
    	public String QueryRegistration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		System.out.print("------queryregistration--------查找病例");
    		String condition="";
    		String pi_id=req.getParameter("pi_id");
    		String pi_name=req.getParameter("pi_name");
    
    		
    		if(!("".equals(pi_id)) && pi_id!=null) {
    			condition = condition + " and r.pi_id = '"+pi_id+"'";
    		}
    		if(!("".equals(pi_name))&& pi_name!=null) {
    			condition = condition + " and pi_name = '"+pi_name+"'";
    		}
    	
    		System.out.print(condition);
    		List<Registration> registrationList= registrationDaoImpl.queryRigistration(condition);
    		req.getSession().setAttribute("registrationList", registrationList);
    		return"/html/Guahao/info.jsp";
    	}
    	
        public String addRegistration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		System.out.println("-----addmethod----");
        	UserinfosDao userDaoImpl = new UserinfosDaoimpl();
        	String rg_id = "rg-"+UUIDUtil.getId(); 
    		String pi_id= req.getParameter("pi_id"); 
    		Patients patients =patientsDaoimpl.findById(pi_id);
    		Userinfos userinfos1=(Userinfos)req.getSession().getAttribute("userinfos");
    		String u_id=userinfos1.getU_id() ;  
    		String d_id= req.getParameter("d_id");     //医生id
    		Userinfos userinfos = userDaoImpl.userFindByUid(d_id);
    		Double rg_price= Double.parseDouble(req.getParameter("rg_price"));
    		Date date= new Date();
    		SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    		String rg_date= ft.format(date);
    		int rg_status =0;
            Registration registration = new Registration(rg_id, patients, u_id, userinfos, rg_price, rg_date, rg_status);
        	registrationDaoImpl.addRegistration(registration);
        	resp.setContentType("text/html;charset=UTF-8");
        	resp.getWriter().println("<script>alert('挂号成功！');window.location.href='html/Guahao/guahao.jsp'</script>");
    		return null;
    	}
       public String delRegistration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  System.out.println("----tuihao------");
    	   String rg_id= req.getParameter("rg_id");
    	   System.out.println(rg_id);
    	   registrationDaoImpl.delRegistration(rg_id);
    	   String condition ="";
    	   List<Registration> registrationList= registrationDaoImpl.queryRigistration(condition);
   		   req.getSession().setAttribute("registrationList", registrationList);
    	   return"html/Guahao/info.jsp";
       }
       }
