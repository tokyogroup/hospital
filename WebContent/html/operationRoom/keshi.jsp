<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询科室信息</title>
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
        <td valign="bottom" class="title">查询科室信息</td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
  <tr>
    <td class="td_top">科室编号</td>
    <td class="td_top">科室名称</td>
    <td class="td_top">科室地址</td>
    
    <td class="td_top">操作</td>
  
   

  </tr>
   <c:forEach var="section" items="${secitonList}">
  
    <tr>
    <td class="td07">${section.s_id}</td>
    <td class="td07">${section.s_name}</td>
    <td class="td07">${section.s_addr}</td>
    <td class="td07"><a href="SectionServlet?method=sectionUpdatePwd&s_id=${section.s_id}">修改</a></td>
   


  </tr> 
  
  </c:forEach>
 

  
</table>
<table width="95%"  border="0" cellpadding="0" cellspacing="0" class="table02" align="center">
  <tr>
    <td height="30" align="right"><img src="../../images/1.gif" width="4" height="5" align="absmiddle"> 首页　 <img src="../../images/2.gif" width="3" height="5" align="absmiddle"> 上一页　 <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页　 <img src="../../images/3.gif" width="4" height="5" align="absmiddle"> 末页　　共 1 页 1 条记录</td>
  </tr>
</table>
</body>
</html>