package com.azeroth.dao;

import java.util.List;

import com.azeroth.bean.Userinfos;

public interface UserinfosDao {
	/*1.增删改查
	2.根据uid password 修改密码
	3.根据uid 查看个人信息
	4.查看所有医生信息*/
	boolean userAdd(UserinfosDao userinfos);//增加
	boolean userDelete(String u_id);//删除
	boolean userUpdate(UserinfosDao userinfos);//修改
	List<Userinfos> userFindAll();//查询所有
	boolean userLogin(String u_id,String u_pwd);//登录
	Userinfos userFindByUid(String u_id);//查询个人信息
	boolean userUpPwd(String u_id,String u_pwd);//修改密码
	List<Userinfos> userFindDoctor();//查询所有医生
	List<Userinfos> userFindDoctorbysid(int s_id);//查询同个部门的医生
}
