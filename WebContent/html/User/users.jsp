<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户操作</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../../js/check.js"></script>
<script language="javascript" src="../../js/checkAll.js"></script>
<script language="javascript" src="../../js/clientSideApp.js"></script>
<SCRIPT language=JavaScript type=text/JavaScript>
function windowOpen(theURL,winName,features,width,hight,scrollbars,top,left) 
{
  var parameter="top="+top+",left="+left+",width="+width+",height="+hight;
  if(scrollbars=="no")
 {parameter+=",scrollbars=no";}
  else
 {parameter+=",scrollbars=yes";}
  window.open(theURL,winName,parameter);
}
</SCRIPT>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
      <tr>
        <td width="15"><img src="../../images/index_32.gif" width="9" height="9"></td>
        <td valign="bottom" class="title">用户操作</td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<form action="UserinfosServlet?method=userFindByUname" method="post">
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td_page">
用户名：<input name="u_name" size="10" type="text" class="input"   id="PARA_YM_NOW2" next="A001014" alt="查询年月|0|d|||" value="" onFocus="{obtainFocus(this),this.select()}" onKeyPress="gotoNextInput(this)" onBlur="matchInput(this)" ><!--<input type="button"  class="button_select" onClick="fPopUpCalendarDlg('PARA_YM_NOW2')"> -->

<input name="Submit" type="submit" class="buttonface" value=" 查询 "></td>
</form>
  </tr>
</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
  <tr>
    <td class="td_top">用户id</td>
    <td class="td_top">用户姓名</td>
    <td class="td_top">用户性别</td>
    <td class="td_top">用户年龄</td>
    <td class="td_top">所在科室</td>
    <td class="td_top">用户邮箱</td>
    <td class="td_top">用户简述</td>
    <td class="td_top">操作</td>
   
   

  </tr>
  <c:forEach var="user" items="${userList }">
  
    <tr>
    <td class="td07">${user.u_id}</td>
    <td class="td07">${user.u_name}</td>
    <td class="td07">${user.u_sex}</td>
    <td class="td07">${user.u_age}</td>
    <td class="td07">${user.section.s_name}</td>
    <td class="td07">${user.u_email}</td>
    <td class="td07">${user.u_exp}</td>
    <td class="td07"><a href="UserinfosServlet?method=userDelete&u_id=${user.u_id}">删除</a>&nbsp;&nbsp;<a href="UserinfosServlet?method=updatePwd1&u_id=${user.u_id}">修改密码</a>&nbsp;&nbsp;<a href="UserinfosServlet?method=updateUser1&u_id=${user.u_id}">修改资料</a></td>
   


  </tr> 
  
  </c:forEach>
  
  
 
</table>
      &nbsp&nbsp&nbsp&nbsp;
 <table align="center">
       <tr>
        <td >
        
        
      </tr>
   </table>
</body>
</html>