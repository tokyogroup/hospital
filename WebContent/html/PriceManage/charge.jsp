<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>划价收费</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../../js/check.js"></script>
<script language="javascript" src="../../js/checkAll.js"></script>
<script language="javascript" src="../../js/clientSideApp.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js"></script>
<SCRIPT language=JavaScript type=text/JavaScript>
function windowOpen(theURL,winName,features,width,hight,scrollbars,top,left) 
{
  var parameter="top="+top+",left="+left+",width="+width+",height="+hight;
  if(scrollbars=="no")
 {parameter+=",scrollbars=no";}
  else
 {parameter+=",scrollbars=yes";}
  window.open(theURL,winName,parameter);
};
$(function(){
	
	$("#tijiao").click(function(){
		
		$.getJSON("../../OrderServlet",{method:"orderFind",o_id:$("#o_id").val()},function(data){
			
			var o_total =0;
			 $.each(data,function(index, json){
				var total = json.rc_count * json.medicine.m_price;
				o_total= o_total+total;
				$("#td").append("<tr><td class='td07'>"+json.medicine.m_name+"</td><td class='td07'>"+json.medicine.m_spec+"</td><td class='td07'>"+json.medicine.m_price+"</td><td class='td07'>"+json.rc_count+"</td><td class='td07'>"+total+"</td></tr>");
				
			} )  
			$("#o_total").append(o_total);	
			
		});
	});
	
	$("#updateStatus").click(function(){
		
		$.post("../../OrderServlet",{method:"updateOrder",o_id:$("#o_id").val()},function(){
			alert("确认收费完成!");
			window.location.href='charge.jsp';
			
		});
	});
});


</SCRIPT>


</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
      <tr>
        <td width="15"><img src="../../images/index_32.gif" width="9" height="9"></td>
        <td valign="bottom" class="title">划价收费</td>
      </tr>
    </table></td>
  </tr>
</table>
<br>

<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td_page">订单编号：
    <input name="o_id" size="10" type="text" class="input"  id="o_id" value="" >
<input name="Submit" id="tijiao" type="button" class="buttonface" value=" 查询 "></td>
  </tr>
</table>

<br>

<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01" id="td">
  <tr>
    <td class="td_top">药品名称</td>
    <td class="td_top">药品规格</td>
    <td class="td_top">药品单价</td>
    <td class="td_top">数量</td>
    <td nowrap class="td_top">总价</td>
 
  </tr>
  
</table>
<table width="95%"  border="0" cellpadding="0" cellspacing="0" class="table02" align="center">
  <tr>
    <td height="30" align="right"><img src="../../images/1.gif" width="4" height="5" align="absmiddle"> 首页　 <img src="../../images/2.gif" width="3" height="5" align="absmiddle"> 上一页　 <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页　 <img src="../../images/3.gif" width="4" height="5" align="absmiddle"> 末页　　共 1 页 1 条记录</td>
  </tr>
</table>
<div id="o_total">共计:</div>
 <input type="button" value="确认收费" id="updateStatus">

</body>
</html>