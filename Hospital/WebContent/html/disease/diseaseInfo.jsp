<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>病历编号与信息</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
          <tr>
            <td width="15"><img src="../../images/index_32.gif" width="9" height="9"></td>
            <td valign="bottom" class="title">病历编号与信息</td>
          </tr>
      </table></td>
    </tr>
  </table>
  <form name="form1" method="post" action="">
   <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td_page">病历编号：
    <input name="PARA_YM_NOW" size="10" type="text" class="input"   id="PARA_YM_NOW" next="A001014" alt="查询年月|0|d|||" value="" onFocus="{obtainFocus(this),this.select()}" onKeyPress="gotoNextInput(this)" onBlur="matchInput(this)" readonly>
<input name="Submit" type="submit" class="buttonface" value=" 查询 "></td>
  </tr>
</table>
 
    <table width="95%" border="0" cellspacing="0" cellpadding="0">  
      <tr>
        <td width="90" height="24" class="td_form01">病历编号</td>
        <td class="td_form02"><input name="textfield24" type="text" class="input"></td>
        <td width="90" class="td_form01">病人编号</td>
        <td class="td_form02"><input name="textfield24" type="text" class="input"></td>
      </tr>
      
      
     <tr>
        <td width="90" height="24" class="td_form01">就诊卡号</td>
        <td class="td_form02"><input name="textfield24" type="text" class="input"></td>
        <td width="90" class="td_form01">就诊科室</td>
        <td class="td_form02"><select name="select3">
          <option>骨科</option>
        </select></td>
      </tr>
      
        <tr>       
        <td width="90" class="td_form01">主治医生</td>
        <td class="td_form02"><select name="select3">
          <option>习小平</option>
        </select></td>
        
        <td width="90" height="24" class="td_form01">就诊结果</td>
        <td class="td_form02"><input name="textfield24"   width="340" type="text" class="input"></td>
      </tr>  
    
    </table>
    <br>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      
    </table>
    <p>&nbsp;</p>
    <p><br>
    </p>
  </form>
</center>
</body>
</html>