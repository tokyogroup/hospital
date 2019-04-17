<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>添加药品</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
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
        <td valign="bottom" class="title">添加药品
          <a href="medicalInfo.jsp" style="list-style-type: none" class="buttonface11" id="buttonface2">返回</a>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<form method="post" action="${pageContext.request.contextPath}/html/MedicineServlet?method=medicineAdd">

<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">	
      <tr>
        <td height="24" class="td_form01">药品名称</td>
        <td class="td_form02"><input name="m_name" type="text" class="input" value=""></td>  
   </tr>	
      <tr>
        <td height="24" class="td_form01">药品规格</td>
          <td class="td_form02"><input name="m_spec" type="text" class="input" value=""></td>
   </tr>	
      <tr>
         <td height="24" class="td_form01">药品单价</td>
        <td class="td_form02"><input name="m_price" type="text" class="input" value=""></td>
   </tr>	
      <tr>
        <td height="24" class="td_form01">药品功能</td>
         <td class="td_form02"><input name="m_funciton" type="text" class="input" value=" "></td>
   </tr>	
      <tr>
         <td height="24" class="td_form01">生产厂家</td>
         <td class="td_form02"><input name="m_addr" type="text" class="input" value=""></td>
   </tr>	
      <tr>
        <td height="24" class="td_form01">药品库存</td>
       <td class="td_form02"><input name="m_count" type="text" class="input" value=""></td>
   </tr>	
     
</table>


  <table align="center">
       <tr>
        <td >
          <input name=save  type=submit class=buttonface value= '  提交  '  onclick="   ">        
        <input name="Submit" type="button" class="buttonface" value="  重置  " ></td>
      </tr>
   </table>
</form>
</body>
</html>