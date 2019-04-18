<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看病人信息</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../../js/check.js"></script>
<script language="javascript" src="../../js/checkAll.js"></script>
<script language="javascript" src="../../js/clientSideApp.js"></script>
<script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js"></script>

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
        <td valign="bottom" class="title">查看病人信息</td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<form action="${pageContext.request.contextPath}/PatientsServlet?method=queryPatients" method="post">
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td_page">输入就诊卡号：
    <input name="pi_id" type="text">
病人姓名：<input name="pi_name" type="text">
<input name="" type="submit" class="buttonface" value=" 查询 "></td>

  </tr>
</table>
<br>

<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
  <tr>
    <td class="td_top">就诊卡号</td>
    <td class="td_top">病人姓名</td>
    <td class="td_top">病人性别</td>
    <td class="td_top">病人年龄</td>
    <td class="td_top">手机号</td>
    <td class="td_top">居住地址</td>
   <td nowrap class="td_top">操作</td>
   

  </tr>
  <c:choose>
  <c:when test="${empty patientsList}" >emptyList!!!!!!</c:when>
  <c:otherwise>
  <c:forEach var="patients" items="${patientsList}">
  <tr>
    <td class="td07"> ${patients.pi_id} </td>
    <td class="td07">${patients.pi_name}</td>
    <td class="td07">${patients.pi_sex}</td>
    <td class="td07">${patients.pi_age}</td>
    <td class="td07">${patients.pi_tele}</td>
    <td class="td07">${patients.pi_addr}</td>
      <td class="td07">
        <a href="${pageContext.request.contextPath}/PatientsServlet?method=queryApatient&pi_id=${patients.pi_id}"  target="mainFrame">&nbsp;&nbsp;修改</a>
        <a href="${pageContext.request.contextPath}/PatientsServlet?method=delPatients&pi_id=${patients.pi_id}" target="mainFrame">&nbsp;&nbsp;删除</a>
    </td>
  </tr>
  </c:forEach>
  </c:otherwise>
  </c:choose>
 

  
</table>
</form>
<table width="95%"  border="0" cellpadding="0" cellspacing="0" class="table02" align="center">
  <tr>
    <td height="30" align="right"><img src="../../images/1.gif" width="4" height="5" align="absmiddle"> 首页　 <img src="../../images/2.gif" width="3" height="5" align="absmiddle"> 上一页　 <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页　 <img src="../../images/3.gif" width="4" height="5" align="absmiddle"> 末页　　共 1 页 1 条记录</td>
  </tr>
</table>
</body>
</html>