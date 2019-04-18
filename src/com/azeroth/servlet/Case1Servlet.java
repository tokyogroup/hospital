    package com.azeroth.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azeroth.bean.Case1;
import com.azeroth.bean.Medicine;
import com.azeroth.bean.Order;
import com.azeroth.bean.Patients;
import com.azeroth.bean.Recipe;
import com.azeroth.bean.Section;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.Case1Dao;
import com.azeroth.dao.MedicineDao;
import com.azeroth.dao.OrderDao;
import com.azeroth.dao.PatientsDao;
import com.azeroth.dao.RecipeDao;
import com.azeroth.daoimpl.Case1Daoimpl;
import com.azeroth.daoimpl.MedicineDaoimpl;
import com.azeroth.daoimpl.OrderDaoimpl;
import com.azeroth.daoimpl.PatientsDaoimpl;
import com.azeroth.daoimpl.RecipeDaoimpl;
import com.azeroth.daoimpl.RegistrationDaoImpl;
import com.azeroth.utils.UUIDUtil;

import net.sf.json.JSONArray;
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
	//添加
	public String case1Add2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========Case1Add==========");	
		String pi_id = request.getParameter("pi_id");
		String c_result = request.getParameter("c_result");
		String c_method = request.getParameter("c_method");
		
		String c_id = "c-"+UUIDUtil.getId();
	
		
		Date date =  new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		String c_date = ft.format(date);
		Userinfos userinfos =(Userinfos) request.getSession().getAttribute("userinfos");
		Patients patients = new Patients();
		patients.setPi_id(pi_id);
		
		Case1 case1 =new Case1(c_id,patients,userinfos,c_date,c_result,c_method,0);
		Case1Dao case1Dao = new Case1Daoimpl();
		case1Dao.case1Add(case1);
		//生成订单号
		String o_id ="o-"+UUIDUtil.getId();
		Order order = new Order();
		order.setCase1(case1);
		order.setO_id(o_id);
		order.setO_status(0);
		OrderDao orderDao = new OrderDaoimpl();
		orderDao.orderAdd(order);
		
	
		request.getSession().setAttribute("case1", case1);
		request.getRequestDispatcher("disease/recipe.jsp").forward(request, response);

		return null;
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
	//根据诊号查询过往病例
	public String case1Forbiid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========case1Forbiid==========");	
		String pi_id = request.getParameter("pi_id");
		Case1Dao case1Dao = new Case1Daoimpl();
		List<Case1> case1List= case1Dao.case1FindByPiId(pi_id);
		request.getSession().setAttribute("case1List", case1List);
		
		
		return null;
	}
	//过往病例详情
	public String case1Detailed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========case1Forbiid==========");	
		String c_id = request.getParameter("c_id");
		Case1Dao case1Dao = new Case1Daoimpl();
		Case1 case1= case1Dao.case1FindByCid(c_id);
		RecipeDao recipeDao = new RecipeDaoimpl();
		List<Recipe> recipeList = recipeDao.recipeFindByCid(c_id);
		if(recipeList.size()==0) {
			request.getSession().setAttribute("recipe2List", null);
		}else {
			request.getSession().setAttribute("recipe2List", recipeList);
		}
		request.getSession().setAttribute("case1", case1);
		
		return "disease/patientInfo.jsp";
	
	
	}
	//查询药品
	public String medicineFindByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========medicineFindByName==========");	
		String m_name = request.getParameter("m_name");
		System.out.println(m_name);
		MedicineDao medicineDao = new  MedicineDaoimpl();
		List<Medicine> medicineList = medicineDao.findAll(m_name);
		System.out.println(medicineList.size());
		response.setContentType("text/html;charset=UTF-8");
		if(medicineList.size()==0) {
			System.out.println("无数据");
			response.getWriter().print(1);
			response.getWriter().flush();
		}else {
			System.out.println("有数据");
			JSONArray json = JSONArray.fromObject(medicineList);
			response.getWriter().print(json);
			response.getWriter().flush();
		}
	
		
		return null;
	}
	//查询页面根据 piid 查询
	public String caseFindAllByPiid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========caseFindAllByPiid==========");	
		String pi_id = request.getParameter("pi_id");
		Case1Dao case1Dao = new Case1Daoimpl();
		
		List<Case1> case1List= case1Dao.case1FindByPiId(pi_id);
		request.getSession().setAttribute("case1List", case1List);
		return "disease/diseaseBrowse.jsp";
	
	
	}
	//查询页面 根据cid 查询
	public String caseFindByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========caseFindByCid==========");	
		Case1Dao case1Dao = new Case1Daoimpl();
		String c_id = request.getParameter("c_id");
		Case1 case1= case1Dao.case1FindByCid(c_id);
		List<Case1> case1List= new ArrayList<Case1>();
		case1List.add(case1);
		
		request.getSession().setAttribute("case1List", case1List);
		return "disease/diseaseBrowse.jsp";
	
	
	}
	
	//修改挂号状态
	public String updateStatusRg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========updateStatusRg==========");	
		String rg_id = request.getParameter("rg_id");
		RegistrationDaoImpl rgDaoimpl  = new RegistrationDaoImpl();
		boolean flag = rgDaoimpl.updateStatusRegistration(rg_id);
		response.setContentType("text/html;charset=UTF-8");
		if(flag) {
			response.getWriter().println("<script>alert('修改挂号状态成功！');window.location.href='disease/patientsList.jsp'</script>");
		}else {
			response.getWriter().println("<script>alert('修改挂号状态失败,请重试尝试！');window.location.href='disease/rgUpdateStatus.jsp'</script>");
		}

		return null;
	}
	
}
