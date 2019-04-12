<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改用户</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<SCRIPT language=JavaScript type=text/JavaScript>
function formCheck(){
	       var pwd1 = document.getElementById("newPwd").value;
	       var pwd2 = document.getElementById("newPwd2").value;
	       if(pwd1!=pwd2){
	       alert("两次输入的密码不一致！");
	       return false;
	       }
	       return true;
	    }

</SCRIPT>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
      <tr>
        <td width="15"><img src="../../images/index_32.gif" width="9" height="9"></td>
        <td valign="bottom" class="title">修改用户
          <a href="medicalInfo.jsp" style="list-style-type: none" class="buttonface11" id="buttonface2">返回</a>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<form action="./UserinfosServlet?method=updatePwd2" method="post">
<table width="95%" border="0" cellpadding="2" cellspacing="0" align="center">
  <tr> 
    <td width="272" class="td_form01"><div align="right">旧密码：</div></td>
    <td width="481" class="td_form02"><div align="left"><input name="oldPwd" type="password" class="input" id="textName" size="30" required="required"></div></td> 
 </tr>
   <tr> 
    <td width="272" class="td_form01"><div align="right">新密码：</div></td>
    <td width="481" class="td_form02"><div align="left"><input name="newPwd" type="password" class="input" id="newPwd" size="30" required="required">（8--20位有效字符）</div></td> 
 </tr>
   <tr> 
    <td width="272" class="td_form01"><div align="right">密码确认：</div></td>
    <td width="481" class="td_form02"><div align="left"><input   onchange="formCheck()" name="textfield" type="password" class="input" id="newPwd2" size="30" required="required">（8--20位有效字符）</div></td> 
 </tr>
 </tr>
   <tr> 
    <td width="272" class="td_form01"><div align="right" style="color: red">${pwdWrong}</div></td>
   </div></td> 
 </tr>
 
 </table>    
 <table align="center">
       <tr>
        <td >
          <input name=save  type="submit" class=buttonface value= '  提交  ' >        
        	
      </tr>
   </table>
</form>
</body>
</html>