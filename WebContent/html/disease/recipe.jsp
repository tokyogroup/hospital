<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>根据名字模糊查询药品信息</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript">
$(function(){
	 $("#medCheck").click(function(){
	
		 $.getJSON("${pageContext.request.contextPath}/html/Case1Servlet",{method:"medicineFindByName",m_name:$("#m_name").val()},function(data){
		 
			 if(data=="1"){
					alert("无此药品,请重新确认");
				}else{
					$("#td").empty();
					$("#td").append(" <tr><td class='td_top'>药品编号</td><td class='td_top'>药品名称</td><td class='td_top'>药品规格</td><td class='td_top'>药品单价</td><td class='td_top'>药品功能</td><td class='td_top'>生产厂家</td><td class='td_top'>库存</td></tr>");
					
					$.each(data,function(index, json){
					
						$("#td").append("<tr><td  id=mid"+index+" class='td07'>"+json.m_id+"</td><td  id=mname"+index+" class='td07'>"+json.m_name+"</td><td class='td07'>"+json.m_spec+"</td><td class='td07'>"+json.m_price+"</td><td class='td07'>"+json.m_function+"</td><td class='td07'>"+json.m_addr+"</td><td class='td07'>"+json.m_count+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='idChange("+index+");return false;'>确认</a></td></tr>");
						
					} ) 
				}
			});
	}); 
	$("#out").click(function(){
		var data = $("#c_id").val();
		window.location.href="../Case1Servlet?method=case1Detailed&c_id="+data;
		
	});
	 
	
	
});

function idChange(data)
{
	var m = "mid"+data;
	var name = "mname"+data;
 var mid= document.getElementById(m).innerHTML;

 var mnanme = document.getElementById(name).innerHTML;
 document.getElementById("m_name").value=mnanme;
 document.getElementById("m_id").value=mid; 
}


</script>

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" 

cellpadding="0">
          <tr>
            <td width="15"></td>
            <td valign="bottom">病例编号:[${case1.c_id}],请添加药品信息</td>
          </tr>
      </table></td>
    </tr>
  </table>
  <form name="form1" method="post" action="${pageContext.request.contextPath}/html/RecipeServlet?method=recipeAdd">
  
  
    <table width=95% border=0 align=center cellpadding=0 cellspacing=0>
    
    <tr align="left" nowrap>
        <td width="78" height="24" align="center"  class=td_form01>病例编号</td>
        <td colspan="3" align="left"  class=td_form02><input id="c_id"  name="c_id" type="text" class="input" 

size="45" value="${case1.c_id}"  style="background:#CCCCCC" readonly="readonly"> </td>

        <td width="146" align="center"  class=td_form01>药品编号</td>
        <td colspan="3" align="left"  class=td_form02><input name="m_id" id="m_id" type="text" class="input" 

size="45"  style="background:#CCCCCC" readonly="readonly"></td>
      </tr>
    
    
      <tr align="left" nowrap>
        <td width="78" height="24" align="center"  class=td_form01>药品名称</td>
        <td colspan="3" align="left"  class=td_form02><input id="m_name" type="text" class="input" 

size="45"> <input id="medCheck" type="button" class="buttonface" value="查询药品信息 "></td>
</tr>
<tr>
        <td width="146" align="center"  class=td_form01>药品数量</td>
        <td colspan="3" align="left"  class=td_form02><input name="rc_count" type="text" class="input" 

size="45"></td>
      </tr>
      
      

    </table>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01" id="td">
  
	
</table>
    <table>
       <tr>
        <td >
          <input name=save  type=submit class=buttonface value= '  提交  ' >        
        <input name="Submit"  id="out" type="button" class="buttonface" value="结束 " ></td>
      </tr>
   </table>



  </form>
</center>
</body>
</html>