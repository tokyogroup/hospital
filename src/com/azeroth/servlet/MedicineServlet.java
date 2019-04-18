package com.azeroth.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azeroth.bean.Case1;
import com.azeroth.bean.Medicine;
import com.azeroth.dao.Case1Dao;
import com.azeroth.dao.MedicineDao;
import com.azeroth.daoimpl.Case1Daoimpl;
import com.azeroth.daoimpl.MedicineDaoimpl;
import com.azeroth.utils.UUIDUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class MedicineServlet
 */
@WebServlet("/MedicineServlet")
public class MedicineServlet extends BaseServlet {
	
	//根据名字模糊查询
	public String medicineFindByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========medicineFindByName==========");	
		String m_name = request.getParameter("m_name");
		MedicineDao medicineDao = new  MedicineDaoimpl();
		List<Medicine> medicineList = medicineDao.findAll(m_name);
		response.setContentType("text/html;charset=UTF-8");
		if(medicineList==null) {
			response.getWriter().print(1);
		}else {
			JSONArray json = JSONArray.fromObject(medicineList);
			response.getWriter().print(json);
			response.getWriter().flush();
		}

		return null;
	}
	
	//药品添加
	
	public String medicineAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========medicineAdd==========");
		String m_id ="me-"+UUIDUtil.getId();
		System.out.println(m_id);
		String m_name = request.getParameter("m_name");
		String m_spec = request.getParameter("m_spec");
		double m_price = Double.valueOf(request.getParameter("m_price"));
		String m_funciton = request.getParameter("m_funciton");
		System.out.println(m_funciton);
		String m_addr = request.getParameter("m_addr");
		int m_count = Integer.parseInt(request.getParameter("m_count"));
		Medicine me = new Medicine(m_id,m_name,m_spec,m_price,m_funciton,m_addr, m_count);
		MedicineDao medicineDao = new  MedicineDaoimpl();
		medicineDao.addMedicine(me);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<script>alert('添加新药品成功！');window.location.href='html/PriceManage/insertyao.jsp'</script>");
		

		return null;
	}
	//查询所有
	public String medicineFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========medicineFindAll==========");
		MedicineDao  medicineDao = new MedicineDaoimpl();
		List<Medicine> medicineList= medicineDao.findAll();
		request.getSession().setAttribute("meList", medicineList);

		return "html/PriceManage/medicalInfo.jsp";
	}
	
	
	//药品查询
	public String medicineFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========medicineFind==========");
		
		String condition="";
		String m_id=request.getParameter("m_id");
		String m_name=request.getParameter("m_name");
		System.out.println(m_id);
		System.out.println(m_name);

		
		if(!("".equals(m_id)) && m_id!=null) {
			condition = condition + " and m_id = '"+m_id+"'";
		}
		if(!("".equals(m_name))&& m_name!=null) {
			condition = condition + " and m_name like '%"+m_name+"%'";
		}
		
		System.out.println(condition);
		MedicineDao  medicineDao = new MedicineDaoimpl();
		List<Medicine> medicineList= medicineDao.find(condition);
		request.getSession().setAttribute("meList", medicineList);

		return "html/PriceManage/medicalInfo.jsp";
	}
	
	//删除药品
	public String delMe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========delMe==========");
		
		String m_id=request.getParameter("m_id");
		MedicineDao  medicineDao = new MedicineDaoimpl();
		medicineDao.delMedicine(m_id);
		return "MedicineServlet?method=medicineFindAll";
	}
	
	public String updateMe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========updateMe==========");
		String m_id=request.getParameter("m_id");
		System.out.println(m_id);
		MedicineDao  medicineDao = new MedicineDaoimpl();
		Medicine medicine = medicineDao.findbyMid(m_id);
		System.out.println(medicine);
		request.getSession().setAttribute("medicine", medicine);
		
		return "html/PriceManage/yaoModify.jsp";
	}
	
	public String updateMe1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========updateMe1==========");
		String m_id=request.getParameter("m_id");
		String m_name = request.getParameter("m_name");
		String m_spec = request.getParameter("m_spec");
		double m_price = Double.valueOf(request.getParameter("m_price"));
		String m_funciton = request.getParameter("m_funciton");
		System.out.println(m_funciton);
		String m_addr = request.getParameter("m_addr");
		int m_count = Integer.parseInt(request.getParameter("m_count"));
		Medicine me = new Medicine(m_id,m_name,m_spec,m_price,m_funciton,m_addr, m_count);
		
		
		MedicineDao  medicineDao = new MedicineDaoimpl();
		medicineDao.modMedicine(me);
		return "MedicineServlet?method=medicineFindAll";
	}
	
}
