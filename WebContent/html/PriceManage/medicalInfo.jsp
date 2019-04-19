<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询结果</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../../js/check.js"></script>
<script language="javascript" src="../../js/checkAll.js"></script>
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
</SCRIPT>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="25" align="center" valign="bottom" class="td06"><table width="98%" border="0" cellspacing="3" cellpadding="0">
      <tr>
        <td width="15"><img src="../../images/index_32.gif" width="9" height="9"></td>
        <td valign="bottom" class="title">药品信息查询
         <a href="message.jsp" style="list-style-type: none" class="buttonface11" id="buttonface2">返回</a>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
<br>
<form action="MedicineServlet?method=medicineFind" method="post">
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td_page">输入药品编号：
    <input  size="20" type="text" class="input"   name="m_id"  >
          药品名称：<input  size="20" type="text" class="input" id="PARA_YM_NOW2" name="m_name">
    <input name="chaxun" type="submit" class="buttonface" value=" 查询 ">
</td>
  </tr>
</table>
</form>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
  <tr>
    <td class="td_top">药品编号</td>
    <td class="td_top">药品名称</td>
    <td class="td_top">药品规格</td>
    <td class="td_top">药品单价</td>
    <td class="td_top">药品功能</td>
    <td class="td_top">生产厂家</td>
    <td class="td_top">库存</td>
    <td nowrap class="td_top">操作</td>

  </tr>
  <c:forEach var="me" items="${meList}">
  <tr>
    <td class="td07">${me.m_id }</td>
    <td class="td07">${me.m_name }</td>
    <td class="td07">${me.m_spec }</td>
    <td class="td07">${me.m_price }</td>
    <td class="td07">${me.m_function }</td>
    <td class="td07">${me.m_addr }</td>
    <td class="td07">${me.m_count }</td>
    <td class="td07">
                     <a href="${pageContext.request.contextPath}/MedicineServlet?method=updateMe&m_id=${me.m_id}" target="mainFrame">修改</a>&nbsp;&nbsp;
                     <a href="${pageContext.request.contextPath}/MedicineServlet?method=delMe&m_id=${me.m_id}" target="mainFrame">删除</a></td>

  </tr>
  </c:forEach>
  
</table>
<table width="95%"  border="0" cellpadding="0" cellspacing="0" class="table02" align="center">
  <tr>
    <td height="30" align="right"><img src="../../images/1.gif" width="4" height="5" align="absmiddle"> 首页　 <img src="../../images/2.gif" width="3" height="5" align="absmiddle"> 上一页　 <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页　 <img src="../../images/3.gif" width="4" height="5" align="absmiddle"> 末页　　共 1 页 1 条记录</td>
  </tr>
</table>
</body>
</html>