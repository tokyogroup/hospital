package com.azeroth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azeroth.bean.Patients;
import com.azeroth.dao.PatientsDao;
import com.azeroth.daoimpl.PatientsDaoimpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.azeroth.daoimpl.PatientsDaoimpl;

/**
 * Servlet implementation class PatientsServlet
 */
@WebServlet("/html/PatientsServlet")
public class PatientsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	public String queryPatientsbyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");   
		PatientsDao pdi= new PatientsDaoimpl();
		String pi_id= req.getParameter("pi_id");
		Patients patients =pdi.findById(pi_id);
		JSONObject jobj = JSONObject.fromObject(patients);
    	resp.getWriter().println(jobj);
    	resp.getWriter().flush();

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
		PatientsDao pdi= new PatientsDaoimpl();
		pdi.addPatient(patients);
		
		resp.setContentType("text/html;charset=UTF-8");
    	resp.getWriter().println("<script>alert('就诊卡办理成功！');window.location.href='Guahao/guahao.jsp'</script>");
		return  null;
	}

}
