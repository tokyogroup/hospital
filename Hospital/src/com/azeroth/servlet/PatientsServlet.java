package com.azeroth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azeroth.bean.Patients;
import com.azeroth.dao.PatientsDao;
import com.azeroth.daoimpl.PatientsDaoImpl;

/**
 * Servlet implementation class PatientsServlet
 */
@WebServlet("/PatientsServlet")
public class PatientsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	public String queryPatientsbyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PatientsDao pdi= new PatientsDaoImpl();
		String pi_id= req.getParameter("pi_id");
		Patients patients =pdi.queryPatientsbyid(pi_id);
		req.getSession().setAttribute("patients", patients);
		
		return null;
	}
   
	public String addPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pi_id=req.getParameter("pi_id");
		String pi_name=req.getParameter("pi_name");
		String pi_sex=req.getParameter("pi_sex");
		String pi_date= req.getParameter("pi_date");
		int pi_age= Integer.parseInt(req.getParameter("pi_age"));
		String pi_tele= req.getParameter("pi_tele");
		String pi_addr= req.getParameter("pi_addr");
		Patients patients = new Patients(pi_id, pi_name, pi_sex, pi_age, pi_date, pi_tele, pi_addr);
		PatientsDao pdi= new PatientsDaoImpl();
		pdi.addPatients(patients);
		return"html/Guahao/guahao.jsp";
	}

}
