package com.azeroth.test;

import com.azeroth.bean.Userinfos;
import com.azeroth.dao.PatientsDao;
import com.azeroth.dao.UserinfosDao;
import com.azeroth.daoimpl.PatientsDaoimpl;
import com.azeroth.daoimpl.UserinfosDaoimpl;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UserinfosDao u = new UserinfosDaoimpl();
		//Userinfos userinfos = new Userinfos("u0005",3,"pr2","123","诸葛",2,18,"男","123456789",2,"1231451@163.com","门诊展飞");
		/*u.userAdd(userinfos);*/
		//u.userDelete("u0004");
		//System.out.println(u.userFindByUid("u0005"));
		//u.userUpdate(userinfos);
		
	/*	   for(int i=1;i<100;i++){ 
               String newStr = "UU"+String.format("%04d",i); 
  System.out.println(newStr); 
      } */
		
		
		
		PatientsDao p = new PatientsDaoimpl();
		System.out.println(p.findById("uu123").getPi_sex());
		
		
	}

}
