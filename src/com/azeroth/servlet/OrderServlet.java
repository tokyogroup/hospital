package com.azeroth.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azeroth.bean.Medicine;
import com.azeroth.bean.Order;
import com.azeroth.bean.Recipe;
import com.azeroth.dao.Case1Dao;
import com.azeroth.dao.MedicineDao;
import com.azeroth.dao.OrderDao;
import com.azeroth.dao.RecipeDao;
import com.azeroth.daoimpl.Case1Daoimpl;
import com.azeroth.daoimpl.MedicineDaoimpl;
import com.azeroth.daoimpl.OrderDaoimpl;
import com.azeroth.daoimpl.RecipeDaoimpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	
	
	public String orderFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========orderFind==========");	
		String o_id = request.getParameter("o_id");
		System.out.println(o_id);
		OrderDao orderDao = new OrderDaoimpl();
		Order order = orderDao.oerderFind(o_id);
		
		String cid = order.getCase1().getC_id();		
		RecipeDao recipeDao = new RecipeDaoimpl();
		List<Recipe> rcList =recipeDao.recipeFindByCid(cid);
		response.setContentType("text/html;charset=UTF-8");
		
			System.out.println("有数据");
			JSONArray json = JSONArray.fromObject(rcList);
			response.getWriter().print(json);
		
	
		
		return null;
	}
	
	public String updateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========updateOrder==========");	
		String o_id = request.getParameter("o_id");
		
		OrderDao orderDao = new OrderDaoimpl();
		Order order = orderDao.oerderFind(o_id);
		String cid = order.getCase1().getC_id();
		orderDao.updateStatus(o_id);
		Case1Dao case1Dao = new Case1Daoimpl();
		case1Dao.updateStatus(cid);
		
		response.setContentType("text/html;charset=UTF-8");
		
		
	
		
		return null;
	}
}


