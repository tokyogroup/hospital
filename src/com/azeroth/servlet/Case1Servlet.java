package com.azeroth.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azeroth.bean.Case1;
import com.azeroth.bean.Patients;
import com.azeroth.bean.Section;
import com.azeroth.dao.Case1Dao;
import com.azeroth.dao.PatientsDao;
import com.azeroth.daoimpl.Case1Daoimpl;
import com.azeroth.daoimpl.PatientsDaoimpl;


import net.sf.json.JSONObject;

/**
 * Servlet implementation class Case1Servlet
 */
@WebServlet("/html/Case1Servlet")
public class Case1Servlet extends BaseServlet {
	//跳转添加页面
	public String case1Add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========Case1Add==========");	
		String pi_id = request.getParameter("pi_id");
		System.out.println(pi_id);
		
		return "operationRoom/keshiUpdate.jsp";
	}
	
	//ajax方法根据piid查询病人信息输入到页面
	public String piidCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========piidCheck==========");	
		PatientsDao patientsDao = new PatientsDaoimpl();
		String pi_id = request.getParameter("pi_id");
		Patients patients = patientsDao.findById(pi_id);
		response.setContentType("text/html;charset=UTF-8");
		if(patients==null) {
			response.getWriter().print(1);
		}else {
			JSONObject json = JSONObject.fromObject(patients);
			response.getWriter().print(json);
			response.getWriter().flush();
		}
		
		
		return null;
	}
	
	public String case1Forbiid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========case1Forbiid==========");	
		String pi_id = request.getParameter("pi_id");
		Case1Dao case1Dao = new Case1Daoimpl();
		List<Case1> case1List= case1Dao.case1FindByPiId(pi_id);
		request.getSession().setAttribute("case1List", case1List);
		
		return null;
	}
	
	
	
}
