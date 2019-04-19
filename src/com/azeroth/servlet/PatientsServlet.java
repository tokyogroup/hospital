package com.azeroth.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azeroth.bean.Patients;
import com.azeroth.bean.Registration;
import com.azeroth.dao.PatientsDao;
import com.azeroth.daoimpl.PatientsDaoimpl;
import com.azeroth.utils.UUIDUtil;

import jcumf.umf_javacall;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.azeroth.daoimpl.PatientsDaoimpl;

/**
 * Servlet implementation class PatientsServlet
 */
@WebServlet("/PatientsServlet")
public class PatientsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	public String queryPatientsbyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html; charset=UTF-8");   
		
		
		PatientsDao pdi= new PatientsDaoimpl();
		short status;
        int lDevice ;//通讯设备标识符
        short tblk = 5;//数据块
        short tsector = 1;//扇区号
        short findCardMode = 1; //寻卡模式   set to 1 if multiply card mode, set to 0 if single card mode
        short keyMode = 0;//装入密码模式（0：KEYA,1:KEYB）  refer to manual doc

        char[] pSnrM1 = new char[8];//M1卡序列号 M1 card serial number string
        /*9BFA2345*/
        char[] pRBuffer = new char[16];//返回的信息  读的数据  16进制->ASCII
        
        char[] pSBuffer=new char[16];
        
        umf_javacall rd = new umf_javacall();
        
        
        try {
	        lDevice = rd.fw_init(100, 115200);//lDevice串口标识符
            if (lDevice <= 0) {
                System.out.print("fw_init error!\n");
                
            }
            System.out.print("fw_init ok!\n");

            
            
          
            //寻卡，（串口标识符，寻卡模式，M1卡序列号）
            status = rd.fw_card_hex(lDevice, (short) findCardMode, pSnrM1);//
            if (status != 0) {
                System.out.print("fw_card error!\n 没有卡");
                System.out.print(status + "\n");

            } else {
                System.out.print("fw_card ok!\n  油卡");
                System.out.println(pSnrM1);
            }

            //验证设备密码和卡中密码，（串口标识符，装入密码模式，要验证密码的扇区号）
            status = rd.fw_authentication(lDevice, (short) keyMode, (short) tsector);
            if (status != 0) {
                System.out.print("fw_authentication error!\n");
                System.out.print(status + "\n");
                rd.fw_exit(lDevice);

            } else {
            	
            	//蜂鸣，（通讯设备标识符，蜂鸣时间）
                status = rd.fw_beep(lDevice, (short) 10);
                if (status != 0) {
                    System.out.print("fw_beep error!\n");
                } else {
                    System.out.print("fw_beep ok!\n");
                }
                System.out.print("fw_authentication ok!\n");
            }

            //读卡，一次读一个块的数据，16个字节。（串口标识符，块地址，数据存放地址）
            status = rd.fw_read(lDevice, (short) tblk, pRBuffer);
            if (status != 0) {
                System.out.print("fw_read error!\n");
                //关闭端口
                rd.fw_exit(lDevice);
            } else {
                System.out.print("fw_read ok!\n");
                //打印读取的数据
                System.out.println(pRBuffer);
            }

            //关闭端口
            status = rd.fw_exit(lDevice);
            if (status != 0) {
                System.out.print("fw_exit error!\n");
            } else {
                System.out.print("fw_exit ok!\n");
            }

        } catch (Exception e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
        
        String pi_id = String.valueOf(pRBuffer);
		StringBuffer str=new StringBuffer();
		for(int i=0;i<8;i++){
			if(pi_id.charAt(i)!='0'){
				str.append(pi_id.charAt(i));	
		}
		}
		pi_id=str.toString();
		System.out.println(pi_id);
		
		//String pi_id= req.getParameter("pi_id");
		Patients patients =pdi.findById(pi_id);
		JSONObject jobj = JSONObject.fromObject(patients);
    	resp.getWriter().println(jobj);
    	resp.getWriter().flush();

		return null;
	}
   
	public String addPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pi_id="pi"+UUIDUtil.getId();
		String pi_name=req.getParameter("pi_name");
		String pi_sex=req.getParameter("pi_sex");
		String pi_date= req.getParameter("pi_date");
		
		
		 short status;
	        int lDevice ;//通讯设备标识符
	        short tblk = 5;//数据块
	        short tsector = 1;//扇区号
	        short findCardMode = 1; //寻卡模式   set to 1 if multiply card mode, set to 0 if single card mode
	        short keyMode = 0;//装入密码模式（0：KEYA,1:KEYB）  refer to manual doc

	        char[] pSnrM1 = new char[8];//M1卡序列号 M1 card serial number string
	        /*9BFA2345*/
	        char[] pRBuffer = new char[16];//返回的信息  读的数据  16进制->ASCII
	        
	        char[] pSBuffer=new char[16];
	        
	        umf_javacall rd = new umf_javacall();
			for(int i=0;i<pi_id.length();i++){
				pSBuffer[i]=pi_id.charAt(i);
			}
			for(int i=15;i>=pi_id.length();i--){
				pSBuffer[i]='0';
			}
	        
	        
	        
	  

	        
	 try {
	        lDevice = rd.fw_init(100, 115200);//lDevice串口标识符
            if (lDevice <= 0) {
                System.out.print("fw_init error!\n");
                
            }
            System.out.print("fw_init ok!\n");

            //寻卡，（串口标识符，寻卡模式，M1卡序列号）
            status = rd.fw_card_hex(lDevice, (short) findCardMode, pSnrM1);//
            if (status != 0) {
                System.out.print("fw_card error!\n");
                System.out.print(status + "\n");

            } else {
                System.out.print("fw_card ok!\n");
                System.out.println(pSnrM1);
            }

            //验证设备密码和卡中密码，（串口标识符，装入密码模式，要验证密码的扇区号）
            status = rd.fw_authentication(lDevice, (short) keyMode, (short) tsector);
            if (status != 0) {
                System.out.print("fw_authentication error!\n");
                System.out.print(status + "\n");
                rd.fw_exit(lDevice);

            } else {
                System.out.print("fw_authentication ok!\n");
            }


            //将信息写入块，（串口标识符，块地址，信息）注意M1卡0，3，7，11...是密码块
            status = rd.fw_write(lDevice, (short) tblk, pSBuffer);
            if (status != 0) {
                System.out.print("fw_write error!\n");
                //关闭端口
                rd.fw_exit(lDevice);

            } else {
                System.out.print("fw_write ok!\n");
            }
            
            

            //读卡，一次读一个块的数据，16个字节。（串口标识符，块地址，数据存放地址）
            status = rd.fw_read(lDevice, (short) tblk, pRBuffer);
            if (status != 0) {
                System.out.print("fw_read error!\n");
                //关闭端口
                rd.fw_exit(lDevice);
            } else {
                System.out.print("fw_read ok!\n");
                //打印读取的数据
                System.out.println(pRBuffer);
            }

            //关闭端口
            status = rd.fw_exit(lDevice);
            if (status != 0) {
                System.out.print("fw_exit error!\n");
            } else {
                System.out.print("fw_exit ok!\n");
            }

        } catch (Exception e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
	       
	        String id = String.valueOf(pRBuffer);
			StringBuffer str=new StringBuffer();
			for(int i=0;i<8;i++){
				if(id.charAt(i)!='0'){
					str.append(id.charAt(i));	
			}
			}
			id=str.toString();
			System.out.println(id);
    
		int pi_age= Integer.parseInt(req.getParameter("pi_age"));
		String pi_tele= req.getParameter("pi_tele");
		String pi_addr= req.getParameter("pi_addr");
		Patients patients = new Patients(pi_id, pi_name, pi_sex, pi_age, pi_date, pi_tele, pi_addr);
		PatientsDao pdi= new PatientsDaoimpl();
		pdi.addPatient(patients);
		
		resp.setContentType("text/html;charset=UTF-8");
    	resp.getWriter().println("<script>alert('就诊卡办理成功！');window.location.href='html/Guahao/guahao.jsp'</script>");
	        
	       
	
			 return  null;
	}
	public String queryPatients(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.print("------queryPatients--------查找病人");
		PatientsDao patientsDaoimpl = new PatientsDaoimpl();
		String condition="";
		String pi_id=req.getParameter("pi_id");
		String pi_name=req.getParameter("pi_name");

		if(!("".equals(pi_id)) && pi_id!=null) {
			condition = condition + " and pi_id = '"+pi_id+"'";
		}
		if(!("".equals(pi_name))&& pi_name!=null) {
			condition = condition + " and pi_name = '"+pi_name+"'";
		}
	
		System.out.print(condition);
		List<Patients> patientsList = new ArrayList<Patients>();
		patientsList= patientsDaoimpl.queryPatients(condition);
		req.getSession().setAttribute("patientsList", patientsList);
		return"html/Guahao/patientInfo.jsp";
	}
	public String queryApatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PatientsDao patientsDaoimpl = new PatientsDaoimpl();
		String condition="";
		String pi_id=req.getParameter("pi_id");
		if(!("".equals(pi_id)) && pi_id!=null) {
			condition = condition + " and pi_id = '"+pi_id+"'";
		}
		List<Patients> patientsList = new ArrayList<Patients>();
		patientsList= patientsDaoimpl.queryPatients(condition);
		req.getSession().setAttribute("aPatient", patientsList);
		return"html/Guahao/patientsModify.jsp";
	}
	public String delPatients(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.print("------queryPatients--------删除病人");
		String pi_id=req.getParameter("pi_id");
		String condition ="";
		PatientsDao patientsDaoimpl = new PatientsDaoimpl();
		patientsDaoimpl.delPatient(pi_id);
		List<Patients> patientsList = new ArrayList<Patients>();
		patientsList= patientsDaoimpl.queryPatients(condition);
		req.getSession().setAttribute("patientsList", patientsList);
		resp.setContentType("text/html;charset=UTF-8");
    	resp.getWriter().println("<script>alert('删除病人成功！');window.location.href='html/Guahao/patientInfo.jsp'</script>");
		return null;
	}
	public String modifyPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String condition ="";
		PatientsDao patientsDaoimpl = new PatientsDaoimpl();
		String pi_tele= req.getParameter("pi_tele");
		String pi_addr= req.getParameter("pi_addr");
		String pi_id= req.getParameter("pi_id");
		System.out.println("------"+pi_tele);
		System.out.println("------"+pi_addr);
		System.out.println("------"+pi_id);
		patientsDaoimpl.modPatient(pi_tele, pi_addr, pi_id);
		List<Patients> patientsList = new ArrayList<Patients>();
		patientsList= patientsDaoimpl.queryPatients(condition);
		req.getSession().setAttribute("patientsList", patientsList);
		resp.setContentType("text/html;charset=UTF-8");
    	resp.getWriter().println("<script>alert('修改病人成功！');window.location.href='html/Guahao/patientInfo.jsp'</script>");
		return null;
	}
}
