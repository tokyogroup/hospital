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
<form name="form1" method="post" action="../Case1Servlet?method=caseFindAllByPiid">
     <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td_page">就诊卡号：
    <input name="pi_id" size="10" type="text" class="input"  >
<input name="Submit" type="submit" class="buttonface" value=" 查询 "></td>

  </tr>
  </form>
 <form name="form1" method="post" action="../Case1Servlet?method=caseFindByCid"> 
  <tr>
  <td class="td_page">病例编号：
    <input name="c_id" size="10" type="text" class="input" >
<input name="Submit" type="submit" class="buttonface" value=" 查询 "></td>
  </tr>
  
  
</table>
</form>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
   <tr>
      <td class="td_top">就诊卡号</td>
      <td class="td_top">姓名</td>
      <td class="td_top">病例编号</td>
       <td class="td_top">诊断时间</td>
       <td class="td_top">操作</td>
   </tr>
   <c:forEach var="casebyid" items="${caseList}">   
    <tr>
    <td class="td07">${casebyid.patients.pi_id }</td>
    <td class="td07">${casebyid.patients.pi_name }</td>
    <td class="td07">${casebyid.c_id}</td>
    <td class="td07">${casebyid.c_date}</td>
    <td class="td07"><a href="../Case1Servlet?method=case1Detailed&c_id=${casebyid.c_id}">详情</a></td>
  </tr>
   </c:forEach>

</table>

<body>
</body>
</html>