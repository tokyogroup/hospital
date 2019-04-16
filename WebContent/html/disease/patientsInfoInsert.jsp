<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>病人诊断信息录入</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../jquery/jquery-1.9.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#pi_id").blur(function(){
		$.getJSON("../Case1Servlet?",{method:"piidCheck",pi_id:$("#pi_id").val()},function(data){
			if(data=="1"){
				alert("诊号错误,请重新确认");
			}else{
				
				
				 $("#pi_sex").val(data.pi_sex); 
				 $("#pi_name").val(data.pi_name); 
				 $("#pi_age").val(data.pi_age); 
			}
		});
	});
	$("#findCase1List").click(function(){
		$.post("../Case1Servlet?",{method:"case1Forbiid",pi_id:$("#pi_id").val()},function(){
			window.location.href='diseaseBrowse.jsp';
			
		});
		
		
	});
	
});

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
          <tr>
            <td width="15"><img src="../../images/index_32.gif" width="9" height="9"></td>
            <td valign="bottom" class="title">病人诊断信息录入</td>
          </tr>
      </table></td>
    </tr>
  </table>
  <form name="form1" method="post" action="../Case1Servlet?method=case1Add">
    <table width="95%" border="0" cellspacing="0" cellpadding="0">
      <tr>
       	
        <td width="90" class="td_form01">医生姓名</td>
        <td class="td_form02"><input name="textfield24" type="text" class="input" readonly="readonly" value="${userinfos.u_name}"></td>
        <td width="90" class="td_form01">所属科室</td>
        <td class="td_form02"><input name="textfield24" type="text" class="input" readonly="readonly" value="${userinfos.section.s_name}"></td>  
      </tr>
      
      
       <tr>  
        <td width="90" height="24" class="td_form01">就诊卡号</td>
        <td class="td_form02"><input  id="pi_id" name="pi_id" type="text" class="input" required="required"> <input id="findCase1List"  type="button" class=buttonface value= '  查询病例记录  '> </td> 
        <td width="90" class="td_form01">病人性别</td>
        <td class="td_form02"><select name="select3" id="pi_sex">
          <option value="男">男</option>
          <option value="女">女</option>
        </select></td>
        </tr>
      
      <tr>
       
        <td width="90" height="24" class="td_form01">病人姓名</td>
        <td class="td_form02"><input id ="pi_name" name="pi_name" type="text" class="input" readonly="readonly"></td>
        <td width="90" height="24" class="td_form01">病人年龄</td>
        <td class="td_form02"><input id="pi_age" name="pi_age" type="text" class="input" readonly="readonly"></td>
      </tr>
      
    
         
        <tr align="left" nowrap>
        <td height="24" align="center"  class=td_form01>诊断结果：</td>
        <td height="24" colspan="5" align="left" valign="middle"  class=td_form01><label>
          <textarea name="c_result" id=""c_result"" cols="100" rows="5" required="required"></textarea>
        </label></td>

      </tr>  
        <tr align="left" nowrap>
        <td height="24" align="center"  class=td_form01>诊断方法：</td>
        <td height="24" colspan="5" align="left" valign="middle"  class=td_form01><label>
          <textarea name="c_method" id="c_method" cols="100" rows="5" required="required"></textarea>
        </label></td>

      </tr>  
      
       
    </table>
    <br>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center">
          <input name=save  type=submit class=buttonface value= '  提交  '>        
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