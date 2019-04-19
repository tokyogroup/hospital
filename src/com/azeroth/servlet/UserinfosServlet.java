package com.azeroth.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.azeroth.bean.Section;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.SectionDao;
import com.azeroth.dao.UserinfosDao;
import com.azeroth.daoimpl.SectionDaoimpl;
import com.azeroth.daoimpl.UserinfosDaoimpl;
import com.azeroth.utils.UUIDUtil;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class UserinfosServlet
 */
@WebServlet("/html/UserinfosServlet")
public class UserinfosServlet extends BaseServlet {
	
	UserinfosDao userinfosDao = new UserinfosDaoimpl();
	//登录
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=======UserinfosServlet=========");
		request.setCharacterEncoding("utf-8");
		String u_id = request.getParameter("u_id");
		String u_pwd = request.getParameter("u_pwd");
		Userinfos userinfos = userinfosDao.userLogin(u_id, u_pwd);
		if(userinfos==null) {
			request.setAttribute("wrong", "账号或密码错误!");
			return "login.jsp";
		}else {
			request.getSession().setAttribute("userinfos", userinfos);
		}
		response.setContentType("text/html;charset=utf-8");
		
        
        //得到客户端的所有的Cookie 
        Cookie[] cookies=request.getCookies();
        //从Cookie中找出存储最后登录时间的Cookie
        //Cookie是一个键值对，并且键和值都是String的
        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                String name = cookies[i].getName();//得到Cookie的name
                if("lastAccessTime".equals(name))
                {
                    String time = cookies[i].getValue();//得到最后登录时间，时间是字符串类型的
                    long  t = Long.parseLong(time);
                    String lastLoginTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(t));
                    request.getSession().setAttribute("lastLoginTime", lastLoginTime);
                }
            }
        }

        //把这次的登录时间以Cookie的形式发送给客户端
        //创建Cookie
        Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
        cookie.setPath(request.getContextPath());// /day35_cookie 只要是路径以 /day35_cookie开头的都可以接收到Cookie
        //cookie.setPath("/");//  /day35_cookie
        //把cookie发送给客户端
        response.addCookie(cookie);

		
		return "index.jsp";
	}
	//退出
	public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession ss = request.getSession();
		ss.removeAttribute("wrong");
		ss.removeAttribute("userinfos");
		return "./login.jsp";
	}
	
	
	//查看所有信息
	public String userFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("==========userFindAll==========");
		List<Userinfos> userList = userinfosDao.userFindAll();
		request.getSession().setAttribute("userList", userList);
		return "User/users.jsp";
	}
	
	
	//修改密码1 储存uid 跳转修改密码界面
	public String updatePwd1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String u_id = request.getParameter("u_id");
		request.getSession().setAttribute("u_id", u_id);
		
		
			return "User/userModify.jsp";
		
		
	}//修改密码 跳转到跳转页面 提示修改密码成功 
	public String updatePwd2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("==========updatePwd2==========");
		String u_id = (String)request.getSession().getAttribute("u_id");
		String oldPwd = request.getParameter("oldPwd");
		System.out.println(u_id+oldPwd);
		if(userinfosDao.userLogin(u_id, oldPwd)==null) {
			System.out.println("账号密码错误");
			request.getSession().setAttribute("pwdWrong", "密码错误请重新输入!");
			return "User/userModify.jsp";
		}else {
			String u_pwd = request.getParameter("newPwd");
			userinfosDao.userUpPwd(u_id, u_pwd);
			request.getSession().setAttribute("tiaozhuan", "密码修改成功 正在跳转中~~~");
			return "User/tiaozhuan.jsp";
		}
		
	}
	//修改用户信息 储存uid 跳转
	public String updateUser1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("==========updateUser1==========");
		String u_id = request.getParameter("u_id");
		request.getSession().setAttribute("userForUpdate", userinfosDao.userFindByUid(u_id));
		SectionDao sectionDao = new SectionDaoimpl();
		List<Section> secitonList = sectionDao.sectionFindAll();
		request.getSession().setAttribute("secitonList", secitonList);

		return "User/userUpdate.jsp";

	}
	public String updateUser2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		System.out.println("==========updateUser2==========");
		
		String u_id = request.getParameter("u_id");
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		String pr_id = request.getParameter("pr_id");
		String u_pwd = request.getParameter("u_pwd");
		String u_name = request.getParameter("u_name");
		int u_title =Integer.parseInt(request.getParameter("u_title")) ;
		int u_age =Integer.parseInt( request.getParameter("u_age"));
		String u_sex = request.getParameter("u_sex");
		String u_tel = request.getParameter("u_tel");
		String u_email = request.getParameter("u_email");
		String u_exp = request.getParameter("u_exp");
		String s_name = request.getParameter("s_name");
		String s_addr = request.getParameter("s_addr");
		Userinfos userinfos = new Userinfos(u_id,s_id,pr_id,u_pwd,u_name,u_title,u_age,u_sex,u_tel,0,u_email,u_exp);
	    userinfosDao.userUpdate(userinfos);
	    request.getSession().setAttribute("tiaozhuan", "用户修改成功 正在跳转中~~~");
		return "User/tiaozhuan.jsp";
		
	}
	
	
	
	//用户删除
	public String userDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("==========userDelete==========");
		String u_id = request.getParameter("u_id");
		
			userinfosDao.userDelete(u_id);
			request.getSession().setAttribute("tiaozhuan", "删除成功 正在跳转中~~~");
			return "User/tiaozhuan.jsp";
		
		
	}
	//根据名字模糊查询用户信息
	public String userFindByUname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		System.out.println("==========userFindByUname==========");
		
		String u_name = request.getParameter("u_name");
		System.out.println(u_name);
		
		List<Userinfos> userList = userinfosDao.userFindByUname(u_name);
		request.getSession().setAttribute("userList", userList);

		
		return "User/users.jsp";
		
		
	}
	//查看所有医生信息
	public String userFindDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		System.out.println("==========userFindDoctor==========");
	
		List<Userinfos> doctorList = userinfosDao.userFindDoctor();
		request.getSession().setAttribute("doctorList", doctorList);

		
		return "Guahao/doctorInfo.jsp";
		
		
	}
	//模糊查询医生信息
	public String doctorFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		System.out.println("==========doctorFind==========");
		
		String u_name = request.getParameter("u_name");
		System.out.println(u_name);
		
		List<Userinfos> doctorList = userinfosDao.userFindByUname(u_name);
	
		request.getSession().setAttribute("doctorList", doctorList);

		
		return "Guahao/doctorInfo.jsp";
		
		
	}
	
	//添加用户第一步加载科室信息
	public String userAdd1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		System.out.println("==========userAdd1==========");
		SectionDao sectionDao = new SectionDaoimpl();
		List<Section> secitonList = sectionDao.sectionFindAll();
		request.getSession().setAttribute("secitonList", secitonList);
		return "User/userAdd.jsp";
		
	}
	//获取数据 添加到数据库
	public String userAdd2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		System.out.println("==========userAdd2==========");
		
		String u_id = ("uu-"+UUIDUtil.getId());
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		String pr_id = request.getParameter("pr_id");
		String u_pwd = request.getParameter("u_pwd");
		String u_name = request.getParameter("u_name");
		int u_title =Integer.parseInt(request.getParameter("u_title")) ;
		int u_age =Integer.parseInt( request.getParameter("u_age"));
		String u_sex = request.getParameter("u_sex");
		String u_tel = request.getParameter("u_tel");
		String u_email = request.getParameter("u_email");
		String u_exp = request.getParameter("u_exp");
		String s_name = request.getParameter("s_name");
		String s_addr = request.getParameter("s_addr");
		Userinfos userinfos = new Userinfos(u_id,s_id,pr_id,u_pwd,u_name,u_title,u_age,u_sex,u_tel,0,u_email,u_exp);
	    userinfosDao.userAdd(userinfos);
	    request.getSession().setAttribute("tiaozhuan", "用户添加成功 正在跳转中~~~");
		return "User/tiaozhuan.jsp";
		
	}
	public String querySamesecDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html; charset=UTF-8");    
		System.out.print("//////querysamesecdocservlet");
		int s_id=Integer.parseInt(request.getParameter("s_id"));
		System.out.println(s_id);
		List<Userinfos> sameSecdocList = new ArrayList<Userinfos>();
		sameSecdocList=userinfosDao.userFindDoctorbysid(s_id);
		JSONArray jsonobj=JSONArray.fromObject(sameSecdocList);
    	response.getWriter().println(jsonobj);
    	response.getWriter().flush();
		return null;
	}
	
	
	
}
