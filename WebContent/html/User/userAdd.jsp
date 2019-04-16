<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
            <td valign="bottom" class="title">添加用户</td>
          </tr>
      </table></td>
    </tr>
  </table>
  <form name="form1" method="post" action="UserinfosServlet?method=userAdd2">
    <table width="95%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="90" height="24" class="td_form01">用户姓名</td>
        <td class="td_form02"><input name="u_name" type="text" class="input" required="required"></td>
         <td width="90" class="td_form01">用户性别</td>
        <td class="td_form02"><select name="u_sex">
          <option value="男">男</option>
          <option value="女">女</option>
        </select></td>  
      </tr>
      
      
       <tr>  
        <td width="90" class="td_form01">用户密码</td>
         <td class="td_form02"><input name="u_pwd" type="text" class="input" required="required"></td>
       
      
        <td width="90" height="24" class="td_form01">用户年龄</td>
        <td class="td_form02"><input name="u_age" type="text" class="input" required="required"></td>
        </tr>
      
     
        <td width="90" height="24" class="td_form01">所属科室</td>
         <td class="td_form02"><select name="s_id">
         <option>请选择</option>
         <c:forEach var="sectionByUserAdd" items="${secitonList}">
          <option value="${sectionByUserAdd.s_id}">${sectionByUserAdd.s_name }</option>
         </c:forEach>
         
         
        </select>
        	职称<select name="u_title">
        	<option>请选择</option>
          <option value="0">专家</option>
          <option value="1">普通</option>
        </select></td>
           <td width="90" height="24" class="td_form01">所属权限</td>
        <td class="td_form02"><select name="pr_id">
         <option>请选择</option>
          <option value="pr0">后台管理员</option>
          <option value="pr1">医生</option>
          <option value="pr2">门诊</option>
        </select>
        </td>
      </tr>
      
        <tr>                 
        <td width="90" class="td_form01">联系电话</td>
        <td class="td_form02"><input name="u_tel" type="text" class="input" required="required"></td>
        <td width="90" height="24" class="td_form01">用户邮箱</td>
        <td class="td_form02"><input name="u_email" type="text" class="input" required="required"></td>  
      </tr>  
      
         
       <tr>
        <td width="90" align="center"  class=td_form01>用户描述</td>
        <td colspan="3" align="left"   class=td_form02>
        <textarea name="u_exp" id="textarea" cols="70" rows="5"></textarea>
        </td>
      </tr>

      </tr>  
      
       
    </table>
    <br>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center">
          <input name=save  type="submit" class=buttonface value= '  提交  '>        
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