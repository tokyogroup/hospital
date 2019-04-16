package com.azeroth.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azeroth.bean.Section;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.SectionDao;
import com.azeroth.daoimpl.SectionDaoimpl;

/**
 * Servlet implementation class SectionServlet
 */
@WebServlet("/html/SectionServlet")
public class SectionServlet extends BaseServlet {
	SectionDao sectionDao = new SectionDaoimpl();
	
	//查询所有科室
	public String sectionFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========sectionFindAll==========");	
		List<Section> secitonList = sectionDao.sectionFindAll();
		request.getSession().setAttribute("secitonList", secitonList);
		return "operationRoom/keshi.jsp";
	}
	//修改科室信息
	public String sectionUpdatePwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========sectionUpdatePwd==========");	
		int s_id =Integer.parseInt(request.getParameter("s_id")); 
		Section section =sectionDao.sectionFindBySid(s_id);		
		request.getSession().setAttribute("sectionFind", section);
		return "operationRoom/keshiUpdate.jsp";
	}
	//修改后跳转到 修改成功页面
	public String sectionUpdatePwd2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========sectionUpdatePwd2==========");	
		int s_id =Integer.parseInt(request.getParameter("s_id")); 
		String s_name = request.getParameter("s_name");
		String s_addr = request.getParameter("s_addr");
		Section section = new Section(s_id,s_name,s_addr);
		sectionDao.sectionUpdate(section);
		request.getSession().setAttribute("sectionTiaozhuan", "科室修改成功 跳转中!!!");
		return "operationRoom/tiaozhuan.jsp";
	}
	
	public String sectionAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========sectionAdd==========");	
		String s_name = request.getParameter("s_name");
		String s_addr = request.getParameter("s_addr");
		Section section = new Section();
		section.setS_addr(s_addr);
		section.setS_name(s_name);
		sectionDao.sectionAdd(section);
		request.getSession().setAttribute("sectionTiaozhuan", "科室添加成功 跳转中!!!");
		return "operationRoom/tiaozhuan.jsp";
	}
}
