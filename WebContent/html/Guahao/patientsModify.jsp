<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
          <tr>
            <td width="15"><img src="../../images/index_32.gif" width="9" height="9"></td>
            <td valign="bottom" class="title">就诊卡办理</td>
          </tr>
      </table></td>
    </tr>
  </table>
  <form name="form1" method="post" action="${pageContext.request.contextPath}/PatientsServlet?method=modifyPatient">
    <table width="95%" border="0" cellspacing="0" cellpadding="0">
     <c:choose>
     <c:when test="${emptyaPatient}" >emptyList!!!!!!</c:when>
     <c:otherwise>
     <c:forEach var="patient" items="${aPatient}">
      <tr>
        <td width="90" height="24" class="td_form01">就诊卡号</td>
        <td colspan="3" class="td_form02"><input name="pi_id" type="text" class="input" readonly="readonly" value= ${patient.pi_id}></td>
      </tr>
      <tr>
        <td width="90" height="24" class="td_form01">病人姓名</td>
        <td class="td_form02"><input name="pi_name" type="text" class="input" readonly="readonly" value=${patient.pi_name} ></td>
        <td width="90" class="td_form01">病人性别</td>
        <td class="td_form02"><input name="pi_sex" type="text" class="input" readonly="readonly" value= ${patient.pi_sex}></td>
        </td>  
       </tr>
      <tr>
        <td width="90" height="24" class="td_form01">出生日期</td>
        <td class="td_form02"><input name="pi_date" type="text" class="input" readonly="readonly" value= ${patient.pi_date}></td>
        <td width="90" height="24" class="td_form01">病人年龄</td>
        <td class="td_form02"><input name="pi_age" type="text" class="input" readonly="readonly" value=${patient.pi_date} ></td>
       </tr>
       <tr>
        <td width="90" height="24" class="td_form01">联系电话</td>
        <td class="td_form02"><input name="pi_tele" type="text" class="input" value=${patient.pi_tele}></td>
        <td width="90" height="24" class="td_form01">地    址</td>
        <td class="td_form02"><input name="pi_addr" type="text" class="input" value=${patient.pi_addr}></td>
       </tr>
   </c:forEach>
  </c:otherwise>
  </c:choose>
    </table>
    <br>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center">
          <input name=save  type="submit" class=buttonface value= '  提交  '  onclick="">        
        <input name="Submit" type="button" class="buttonface" value="  取消  " onClick="history.back(-1)"></td>
      </tr>
    </table>
    <p>&nbsp;</p>
    <p><br>
    </p>
  </form>
</center>
</body>
</html>