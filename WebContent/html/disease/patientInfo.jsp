<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>病人诊断信息详情</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
          <tr>
            <td width="15"><img src="../../images/index_32.gif" width="9" height="9"></td>
            <td valign="bottom" class="title">病人诊断信息详情</td>
          </tr>
      </table></td>
    </tr>
  </table>
  <form name="form1" method="post" action="">
    <table width="95%" border="0" cellspacing="0" cellpadding="0">
      <tr>
       
        <td width="90" class="td_form01">病历编号</td>
        <td class="td_form02">${case1.c_id}</td>
        <td width="90" class="td_form01">病人姓名</td>
        <td class="td_form02">${case1.patients.pi_name }</td>  
      </tr>
      
      
       <tr>  
        <td width="90" height="24" class="td_form01">病人年龄</td>
        <td class="td_form02">${case1.patients.pi_age }</td> 
        <td width="90" class="td_form01">病人性别</td>
        <td class="td_form02">${case1.patients.pi_sex }</td>
        </tr>
      
      <tr>
       
        <td width="90" height="24" class="td_form01">医生编号</td>
        <td class="td_form02">${case1.userinfos.u_id }</td>
        <td width="90" height="24" class="td_form01">诊断时间</td>
        <td class="td_form02">${case1.c_date }</td>
      </tr>
      <tr>
       
        <td width="90" height="24" class="td_form01">医生姓名</td>
        <td class="td_form02">${case1.userinfos.u_name }</td>
        <td width="90" height="24" class="td_form01">所属科室</td>
        <td class="td_form02">${case1.userinfos.section.s_name}</td>
      </tr>
      
    
         
       <tr align="left" nowrap>
        <td height="24" align="center"  class=td_form01>诊断结果：</td>
        <td height="24" colspan="5" align="left" valign="middle"  class=td_form01><label>
          <textarea name="c_result" id=""c_result"" cols="100" rows="5" readonly="readonly" >${case1.c_result}</textarea>
        </label></td>

      </tr>  
        <tr align="left" nowrap>
        <td height="24" align="center"  class=td_form01>诊断方法：</td>
        <td height="24" colspan="5" align="left" valign="middle"  class=td_form01><label>
          <textarea name="c_method" id="c_method" cols="100" rows="5" readonly="readonly" >${case1.c_method }</textarea>
        </label></td>
        
<c:if test="${case1.c_status==0 }">
      </tr>  
      <tr align="left" nowrap>
      <td width="90" height="24" class="td_form01"><a href="${pageContext.request.contextPath}/html/disease/recipe.jsp"><b>新增处方</b></a></td>
      </tr>
       </c:if>  
    </table>
     
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01" id="td">
  <tr><td class='td_top'>处方编号</td>
 <td class='td_top'>药品编号</td>  
  <td class='td_top'>药品名称</td>
  <td class='td_top'>药品规格</td>
  <td class='td_top'>药品功能</td>
  <td class='td_top'>生产厂家</td>
  <td class='td_top'>药品数量</td>
  </tr>
 <c:choose>
 <c:when test="${empty recipe2List}">
 </c:when>
 <c:otherwise>
 <c:forEach var="recipe2" items="${recipe2List}">
 <tr><td class='td07'>${recipe2.rc_id }</td>
  <td class='td07'>${recipe2.medicine.m_id }</td>
  <td class='td07'>${recipe2.medicine.m_name }</td>
  <td class='td07'>${recipe2.medicine.m_spec }</td>
  <td class='td07'>${recipe2.medicine.m_function }</td>
  <td class='td07'>${recipe2.medicine.m_addr }</td>
  <td class='td07'>${recipe2.rc_count }
  <c:if test="${case1.c_status==0 }"><a href="${pageContext.request.contextPath}/html/RecipeServlet?method=recipeDel&rc_id=${recipe2.rc_id }&c_id=${case1.c_id}">删除</a>
  </c:if>
  </td></tr>
 
 </c:forEach>
 </c:otherwise>
 </c:choose>
  
	
</table>
    
     <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center">
             
        <input name="Submit" type="button" class="buttonface" value=" 返回 " onClick="history.back(-1)"></td>
      </tr>
    </table>
    <br>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
       
    </table>
    <p>&nbsp;</p>
    <p><br>
    </p>
  </form>
</center>
</body>
</html>