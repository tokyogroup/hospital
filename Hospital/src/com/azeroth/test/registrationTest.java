package com.azeroth.test;

import java.util.List;

import com.azeroth.bean.Registration;
import com.azeroth.bean.Section;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.RegistrationDao;
import com.azeroth.dao.SectionDao;
import com.azeroth.daoimpl.RegistrationDaoImpl;
import com.azeroth.daoimpl.SectionDaoImpl;
import com.azeroth.daoimpl.UserinfosDaoImpl;

public class registrationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    RegistrationDao  redaoimpl = new RegistrationDaoImpl();
    // List<Registration> registList =redaoimpl.queryRigistration();
     //for(Registration registration:registList) {
    //System.out.println(registration.getPi_id());
    UserinfosDaoImpl userDaoImpl = new UserinfosDaoImpl();
   Userinfos userinfos = userDaoImpl.userFindByUid("u0001");
   System.out.println(userinfos.getU_id());
   Registration registration = new Registration("123", "123", "123", userinfos, 15.50, "2019-04-11", 1);
   //Registration registration = new Registration(rg_id, pi_id, u_id, userinfos, rg_price, rg_date, rg_status)
	/*System.out.println(registration.getRg_id());
	System.out.println(registration.getPi_id());
	System.out.println(registration.getU_id());
	System.out.println(registration.getUserinfos().getU_id());
	System.out.println(registration.getRg_price());
	System.out.println(registration.getRg_date());
	System.out.println(registration.getRg_status());*/
  // redaoimpl.addRegistration(registration);

	/*SectionDao sectionDaoImpl = new SectionDaoImpl();
	List<Section> sectionList = sectionDaoImpl.querySections();
	for(Section section :sectionList) {
		System.out.print("--------section.name------"+section.getS_name());*/


}
}
