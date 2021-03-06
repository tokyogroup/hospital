package com.azeroth.dao;

import java.util.List;

import com.azeroth.bean.Userinfos;

public interface UserinfosDao {
	/*1.增删改查
	2.根据uid password 修改密码
	3.根据uid 查看个人信息
	4.查看所有医生信息*/
	boolean userAdd(Userinfos userinfos);//增加
	boolean userDelete(String u_id);//删除
	boolean userUpdate(Userinfos userinfos);//修改
	List<Userinfos> userFindAll();//查询所有
	Userinfos userLogin(String u_id,String u_pwd);//登录
	Userinfos userFindByUid(String u_id);//查询个人信息
	boolean userUpPwd(String u_id,String u_pwd);//修改密码
	List<Userinfos> userFindDoctor();//查询所有医生
	List<Userinfos> userFindByUname(String u_name);//根据名字模糊查询个人信息
	List<Userinfos> userFindDoctorbysid(int s_id);//查询同个部门的医生
	
	
	
	
}
