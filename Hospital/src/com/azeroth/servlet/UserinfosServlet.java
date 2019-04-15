package com.azeroth.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azeroth.bean.Userinfos;
import com.azeroth.dao.UserinfosDao;
import com.azeroth.daoimpl.UserinfosDaoImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class UserinfosServlet
 */
@WebServlet("/UserinfosServlet")
public class UserinfosServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    UserinfosDao userinfos=new UserinfosDaoImpl();
 
	public String querySamesecDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html; charset=UTF-8");    
		System.out.print("//////querysamesecdocservlet");
		int s_id=Integer.parseInt(request.getParameter("s_id"));
		System.out.println(s_id);
		List<Userinfos> sameSecdocList = new ArrayList<Userinfos>();
		sameSecdocList=userinfos.userFindDoctorbysid(s_id);
		JSONArray jsonobj=JSONArray.fromObject(sameSecdocList);
    	response.getWriter().println(jsonobj);
    	response.getWriter().flush();
		return null;
	}

	

}
