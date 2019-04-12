package com.azeroth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azeroth.bean.Userinfos;
import com.azeroth.dao.UserinfosDao;
import com.azeroth.daoimpl.UserinfosDaoimpl;

/**
 * Servlet implementation class UserinfosServlet
 */
@WebServlet("/html/UserinfosServlet")
public class UserinfosServlet extends BaseServlet {
	
	UserinfosDao userinfosDao = new UserinfosDaoimpl();
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=======UserinfosServlet=========");
		String u_id = request.getParameter("u_id");
		String u_pwd = request.getParameter("u_pwd");
		Userinfos userinfos = userinfosDao.userLogin(u_id, u_pwd);
		request.getSession().setAttribute("userinfos", userinfos);
		
		return "index.jsp";
	}
	
}
