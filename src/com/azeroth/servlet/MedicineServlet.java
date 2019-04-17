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
@WebServlet("/html/MedicineServlet")
public class MedicineServlet extends BaseServlet {
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
		response.getWriter().println("<script>alert('添加新药品成功！');window.location.href='PriceManage/insertyao.jsp'</script>");
		

		return null;
	}
	
	public String medicineFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		System.out.println("==========medicineFindAll==========");
		/*MedicineDao 
		List<Medicine> medicineList= medicineDao.*/
		
		

		return null;
	}
}
