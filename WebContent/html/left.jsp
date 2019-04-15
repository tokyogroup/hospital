<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理系统</title>
<link rel="stylesheet" type="text/css" href="style/admin-all.css" />
<link rel="stylesheet" type="text/css" href="style/base.css" />
<link rel="stylesheet" type="text/css" href="style/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="style/jquery-ui-1.8.22.custom.css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" type="text/javascript" src="../js/tree.js"></script>
<script type="text/javascript" src="style/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="style/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="style/index.js"></script>
</head>
<body>
	<div>
		<!--头部开始-->
		<!--头部结束-->
		<!--左边菜单开始-->
		<div class="left_c left" style="top:10px">
			<h1>系统操作菜单</h1>
			<div class="acc">
				<div>
					<a class="one">挂号管理</a>
					<ul class="kid">
						<li><b class="tip"></b><a href="Guahao/lists.jsp"
							target="mainFrame" class="a03">挂号服务</a>
						</li>
						<li><b class="tip"></b><a
							href="PatientsServlet/method=patientsFindAll" target="mainFrame"
							class="a03">查看病人信息</a>
						</li>
						<li><b class="tip"></b><a href="Guahao/message.jsp"
							target="mainFrame" class="a03">信息查询</a>
						</li>
					</ul>
				</div>

				<div>
					<a class="one">病历管理</a>
					<ul class="kid">
						<li><b class="tip"></b><a href="disease/diseaseInfo.jsp" target="mainFrame"
							class="a03">病历编号与信息</a>
						</li>
						<li><b class="tip"></b><a
							href="disease/patientsList.jsp" target="mainFrame"
							class="a03">病人诊断信息管理</a>
						</li>

					</ul>
				</div>
				<div>
					<a class="one">科室管理</a>
					<ul class="kid">
						<li><b class="tip"></b><a
							href="SectionServlet?method=sectionFindAll" target="mainFrame"
							class="a03">查看科室信息</a>
						</li>
                        <li><b class="tip"></b><a
							href="operationRoom/insertkeshi.jsp" target="mainFrame"
							class="a03">添加新科室</a>
						</li>
					</ul>
				</div>
				<div>
					<a class="one">划价管理</a>
					<ul class="kid">
						<li><b class="tip"></b><a
							href="PriceManage/yaoList.jsp" target="mainFrame"
							class="a03">药品管理</a>
						
							<li><b class="tip"></b><a
							href="PriceManage/charge.jsp" target="mainFrame"
							class="a03">划价收费</a>
					
					</ul>
				</div>
                
				<div>
					<a class="one">角色与权限分配</a>
					<ul class="kid">					
						<li><b class="tip"></b>
							<a href="Popedom/popedomAttribute.jsp"  target="mainFrame">角色与权限分配</a>
						</li>
					</ul>
			
				
					
				</div>
				<div>
					<a class="one">用户管理</a>
					<ul class="kid">
						<li><b class="tip"></b><a href="UserinfosServlet?method=userFindAll"
							target="mainFrame" class="a03">用户操作</a>
						</li>
						<li><b class="tip"></b><a href="User/userAdd.jsp"
							target="mainFrame" class="a03">添加新用户</a>                              
						</li>
                    
							    
						
					</ul>
				</div>

				<div id="datepicker"></div>
			</div>

		</div>
		<!--左边菜单结束-->
		<!--右边框架开始-->
        
        
        
        
        




	</div>
</body>
</html>