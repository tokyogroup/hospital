<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询结果</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<!-- <script language="javascript" src="../../js/check.js"></script>
<script language="javascript" src="../../js/checkAll.js"></script>
<script language="javascript" src="../../js/clientSideApp.js"></script> -->
<script src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript">
//查询

/* $(function(){
      $("#btn1").click(function(){
    	  alert(1111111);
    	$.post("${pageContext.request.contextPath}/RegistrationServlet",{method:"QueryRegistration",pi_id:$("#pi_id").val(),pi_name:$("#pi_name").val()},function(){
    		
    	})
    })
}) */
</script> 

<SCRIPT language=JavaScript type=text/JavaScript>
//不知道他写的啥
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
        <td valign="bottom" class="title">挂号查询</td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<form action="${pageContext.request.contextPath}/RegistrationServlet?method=QueryRegistration"  method="post" >
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td_page">就诊卡号<input name="pi_id" size="10" type="text" class="input">   <!--<input type="button"  class="button_select" onClick="fPopUpCalendarDlg('PARA_YM_NOW')"> -->
&nbsp;&nbsp;&nbsp;&nbsp;病人姓名：<input name="pi_name" size="10" type="text" class="input">
<%-- &nbsp;&nbsp;&nbsp;&nbsp;挂号科室：
<select name="s_id" >
          <option value="">---请选择---</option>
          <c:choose>
          <c:when test="${empty sectionList}">empty list!!!</c:when>
          <c:otherwise>
          <c:forEach var="section" items="${sectionList}">
            <option value=${section.s_id}> ${section.s_name} </option>
          </c:forEach>
          </c:otherwise>
          </c:choose>
 </select> --%>
&nbsp;&nbsp;&nbsp;&nbsp;
<input id="btn1" type="submit" class="buttonface" value=" 查询 "></td>
</tr>
</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
  <tr>
    <td class="td_top">就诊卡号</td>
    <td class="td_top">病人姓名</td>
    <td class="td_top">挂号时间</td>
    <td class="td_top">挂号科室</td>
    <td class="td_top">医生姓名</td>
    <td class="td_top">挂号状态</td>
    <td nowrap class="td_top">操作</td>

  </tr>
  <c:choose>
  <c:when test="${empty registrationList}">emptylist!!!!</c:when>
  <c:otherwise>
  <c:forEach var="registration" items="${registrationList}">
  <tr>
    <td class="td07">${registration.patients.pi_id}</td>
    <td class="td07">${registration.patients.pi_name}</td>
    <td class="td07">${registration.rg_date}</td>
    <td class="td07">${registration.userinfos.section.s_name}</td>
    <td class="td07">${registration.userinfos.u_name}</td>
    <td class="td07">${registration.rg_status}</td>
    <td class="td07">
        <a href="${pageContext.request.contextPath}/html/Guahao/guahaoEdit.jsp" target="mainFrame">&nbsp;&nbsp;详情</a>
        <a href="${pageContext.request.contextPath}/html/Guahao/guahaoModify.jsp"  target="mainFrame">&nbsp;&nbsp;修改</a>
        <a href="${pageContext.request.contextPath}/RegistrationServlet?method=delRegistration&rg_id=${registration.rg_id}" target="mainFrame">&nbsp;&nbsp;退号</a>
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