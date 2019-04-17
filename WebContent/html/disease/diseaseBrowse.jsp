<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">

<title>无标题文档</title>
</head>
     <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td_page">病人病例信息：
   </td>
  </tr>
</table>

<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
   <tr>
      <td class="td_top">就诊卡号</td>
      <td class="td_top">姓名</td>
      <td class="td_top">病例编号</td>
       <td class="td_top">诊断时间</td>
       <td class="td_top">操作</td>
   </tr>
   <c:forEach var="case1" items="${case1List}">
   
    <tr>
    <td class="td07">${case1.patients.pi_id }</td>
    <td class="td07">${case1.patients.pi_name }</td>
    <td class="td07">${case1.c_id}</td>
    <td class="td07">${case1.c_date}</td>
    <td class="td07"><a href="${pageContext.request.contextPath}/html/Case1Servlet?method=case1Detailed&c_id=${case1.c_id}">详情</a></td>
  </tr>
   </c:forEach>
   
  



</table>

<body>
</body>
</html>