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
<form name="form1" method="post" action="../Case1Servlet?method=updateStatusRg">
     <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td_page">挂号编号：
    <input name="rg_id" size="10" type="text" class="input"  >
<input name="Submit" type="submit" class="buttonface" value=" 确认"></td>

  </tr>
  
 </table>
</form>

<body>
</body>
</html>