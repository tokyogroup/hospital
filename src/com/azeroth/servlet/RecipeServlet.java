package com.azeroth.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azeroth.bean.Case1;
import com.azeroth.bean.Medicine;
import com.azeroth.bean.Recipe;
import com.azeroth.dao.MedicineDao;
import com.azeroth.dao.RecipeDao;
import com.azeroth.daoimpl.MedicineDaoimpl;
import com.azeroth.daoimpl.RecipeDaoimpl;
import com.azeroth.utils.UUIDUtil;

/**
 * Servlet implementation class RecipeServlet
 */
@WebServlet("/html/RecipeServlet")
public class RecipeServlet extends BaseServlet {
	
	RecipeDao recipeDao = new RecipeDaoimpl();
	public String recipeAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========recipeAdd==========");	
		String rc_id = "rc-"+UUIDUtil.getId();
		String c_id = request.getParameter("c_id");
		String m_id = request.getParameter("m_id");
		int rc_count = Integer.parseInt(request.getParameter("rc_count"));
		MedicineDao medicineDao = new MedicineDaoimpl();
		medicineDao.updateCount(m_id,rc_count);//修改药品库存数量
		Case1 case1 = new Case1();
		case1.setC_id(c_id);
		Medicine medicine = new Medicine();
		medicine.setM_id(m_id);
		Recipe recipe = new Recipe(rc_id,medicine,rc_count,case1);
		recipeDao.recipeAdd(recipe);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<script>alert('添加药品成功！');window.location.href='disease/recipe.jsp'</script>");
		
		
		return null;
	}
}
