<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>病人诊断信息管理</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
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

$(function(){
//加载就诊卡号
loadpi_id();
 		//给pi_id空间绑定改变事件
	    $("#pi_id").change(function(){
	      
	       loadpi_name();
	    	 loadpi_sex();
	    	  loadpi_age();
	    });    

});
//发起异步请求,请求所有的病例编号
function loadpi_id(){
$.ajax({
type:"post",
data:"opt1=queryAll",
dataType:"json",
cache:true,
asynce:true,
url:"../../case.do",
success:function(pis){
alert(pis,length);
var content = "";
for ( i = 0;i<pis.length;i++){
content+="<option value ='"+pis[i].pi_id+"'>"+pis[i].pi_id+"</option>";

}
$("#pi_id").append(content);
}
});
}
 	//当pi_id发生改变时发起异步请求。请求该pi_id所有的pi_name
	function loadpi_name(){
	
	$.ajax({
	type:"post",
	data:"pi_id="+$("#pi_id").val()+"&opt1=queryAll",
	 cache:true,
     asynce:true,
     url:"../../case.docase.do",
      dataType:"json",
      success:function(pi_names){
		var content="";
		
		$("#pi_name").attr("value",pi_names.pi_name);
	}
	 
	});
	}
	


</SCRIPT>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="25" align="center" valign="bottom" class="td06"><table
					width="98%" border="0" cellspacing="3" cellpadding="0">
					<tr>
						<td width="15"><img src="../../images/index_32.gif" width="9"
							height="9">
						</td>
						<td valign="bottom" class="title">病人诊断信息的录入</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<br>
	<table width="95%" border="0" align="center" cellspacing="0"
		cellpadding="0">
		<tr>
			<td width="120" height="24" class="td_form01">就诊卡号</td>
			<td nowrap class=td_form02><select name="pi_id" id="pi_id"
				style="width:167px"></select>
			</td>
			<td width="120" class="td_form01">病人姓名</td>
			<td class="td_form02"><input name="pi_name" id="pi_name"
				type="text" class="input" size="25">
			</td>
		</tr>
		<tr>
				<td class="td_form01">病人性别</td>
				<td nowrap class=td_form02><input name="pi_sex" type="text" class="input" size="25">
				</td>
				<td class="td_form01">病人年龄</td>
				<td nowrap class=td_form02><input name="pi_age" type="text" class="input" size="25">
				</td>
		
		<tr>
			<td height="24" class="td_form01">病历编号</td>
			<td nowrap class=td_form02><input name="c_id" id="c_id"
				type="text" class="input" size="25">
			</td>
			<td class="td_form01">医生编号</td>
			<td nowrap class=td_form02><input name="u_id" id="u_id"
				type="text" class="input" size="25">
			</td>
		</tr>
		<!-- <tr>
			<td class="td_form01">医生姓名</td>
			<td class="td_form02"><input name="u_name" id="u_name"
				type="text" class="input" size="25">
			</td>
			<td class="td_form01">医生职称</td>
			<td class="td_form02"><input name="u_titel" id="u_name"
				type="text" class="input" size="25">
			</td> -->
		</tr>
		<tr>
			<td class="td_form01">处方编号</td>
			<td class="td_form02"><input name="rc_id" id="rc_id" type="text"
				class="input" size="25">
			</td>
			<td class="td_form01">诊断方法</td>
			<td class="td_form02"><input name="c_method" id="c_method"
				type="text" class="input" size="25">
			</td>
			
		</tr>
		<tr>

			<td class="td_form01">药品数量</td>
			<td class="td_form02"><input name="rc_count" id="cr_count"
				type="text" class="input" size="25">
			</td>
			<td class="td_form01">药品名称</td>
			<td class="td_form02"><input name="m_name" id="m_name"
				type="text" class="input" size="25">
			</td>
		</tr>

		<tr>
		<td class="td_form01">诊断结果</td>
			<td class="td_form02"><input name="c_result" id="c_result"
				type="text" class="input" size="25">
			</td>
			
			<td class="td_form01">诊断时间</td>
			<td class="td_form02"><input name="c_date" id="c_date"
				type="text" class="input" size="25" onclick="date();">
			</td>
		</tr>


	</table>
	<br>
	<br>
	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="center"><input name="submit1" type="button"
				class="buttonface" value=" 提交 "
				onClick="window.location.href='Z_Record.jsp'"> &nbsp;&nbsp;
				&nbsp; &nbsp; <input name="submit2" type="button" class="buttonface"
				value=" 返回 " onClick="window.location.href='../../case.do?opt=queryAll'">
			</td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td>&nbsp;&nbsp;&nbsp;</td>
		</tr>
	</table>
	<br>
</body>
</html>