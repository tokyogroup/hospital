<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../jquery/jquery-1.9.1.js"></script>
<script type="text/javascript">
$(function(){
$("#btn1").click(function(){
		$.post("../../PatientsServlet",{method:"queryPatientsbyid",pi_id:$("#pi_id").val()},function(data){
			
		})
	})
	/* 
	 $("#btn3").click(function(){
    	 $.getJSON("PersonServlet",{type:3},function(jsonobj){
    		 $("#td").empty;
    		 $.each(jsonobj,function(index,person){
    		 $("#td").append("<tr><td>"+person.pid+"</td><td>"+person.pname+"</td><td>"+person.sex+"</td><td>"+person.loc+"</td></tr>")  
    		 })
    	 })
     })
	 */
		$("#choosesec").change(function(){
			$.getJSON("../../UserinfosServlet",{method:"querySamesecDoc",s_id:$(this).val()},function(jsonobj){


				 $("#doctor").empty();
				 
				 $.each(jsonobj,function(index,doctor){
		    	 $("#doctor").append("<option>"+doctor.u_name+"</option>")  
		       })
			})
		})
		
		
})
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"">
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
          <tr>
            <td width="15"><img src="../../images/index_32.gif" width="9" height="9"></td>
            <td valign="bottom" class="title">挂号服务</td>
          </tr>
      </table></td>
    </tr>
  </table>
  <form name="form1" method="post" action="../../RegistrationServlet?method=addRegistration">
    <table width="95%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <center><td colspan="4" width="90" height="24" class="td_form01"><b>病人信息</b></td></center>
      </tr>
      
      <tr>
        <td width="90" height="24" class="td_form01">就诊卡号</td>
        <td class="td_form02"><input name="pi_id" type="text" class="input" id="pi_id"><input type="button" id="btn1" value="查询"></td>
         <td width="90" class="td_form01">病人性别</td>
        <td class="td_form02" name="pi_sex">${patients.pi_sex} </td>  
      </tr>
      
      <tr>
        <td width="90" height="24" class="td_form01">病人姓名</td>
        <td class="td_form02" ><input type="text" name="pi_name"> </td>
         <td width="90" height="24" class="td_form01">联系电话</td>
        <td class="td_form02"><input name="pi_tele" type="text" class="input"></td>
      </tr>
      
       <tr>
        <center><td colspan="4" width="90" height="24" class="td_form01"><b>业务办理</b></td></center>
      </tr>
      
       <tr>  
        <td width="90" height="24" class="td_form01" >挂号类型</td>
        <td class="td_form02"><select name="re_type"id="choosetype" >
              <option value="1">急诊</option>
              <option value="2">普通门诊</option>
              <option value="3">专家门诊</option></td>
        <td width="90" height="24" class="td_form01">挂号编号</td>
        <td class="td_form02"><input type="text" name=rg_id></td>   
       </tr>
       <tr>
        <td width="90" class="td_form01">科室名称</td>
        <td class="td_form02">
          <select name="choosesec"id="choosesec">
          <c:choose>
          <c:when test="${empty sectionList}">empty list!!!</c:when>
          <c:otherwise>
          <c:forEach var="section" items="${sectionList}">
            <option value= ${section.s_id}> ${section.s_name} </option>
          </c:forEach>
          </c:otherwise>
          </c:choose>
          </select>
         </td>
         <td width="90" height="24" class="td_form01">挂号日期</td>
         <td class="td_form02"><input type="text" name="rg_date"></td>
      </tr>
      
        <tr>                 
        <td width="90" class="td_form01">医生姓名</td>  
        <td class="td_form02">
            <select id="doctor">
            <c:choose>
            <c:when test="${empty sameSecdocList}">empty list!!!!</c:when>
            <c:otherwise>
            <c:forEach var="doctor" items="${sameSecdocList}">
            <option > ${doctor.u_name} </option>
            </c:forEach>
            </c:otherwise>
            </c:choose>
            </select>
        </td> 
          <td width="90" height="24" class="td_form01">就诊地点</td>
          <td class="td_form02"></td>
      </tr>  
      
        <tr>       
        <td width="90" height="24" class="td_form01">挂号费用</td>
        <td class="td_form02"><input type="text" name=rg_price></td>
         <td width="90" height="24" class="td_form01">操作人员</td>
        <td class="td_form02"><input type="text" name="u_id"></td>  
      </tr>     
    </table>
    <br>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center">
          <input name=save  type="submit" class=buttonface value= '  提交  '  onclick=" ">        
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