<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>服务器基础信息管理</title>
<link rel="icon" type="image/x-icon" href="images/tubiao.jpg" />
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/distpicker.js"></script>
<script src="js/My97DatePicker/WdatePicker.js"></script>

<script>
	$(document).ready(function() {
	
	$("#delete").click(function() {
			var sid = prompt("请输入你想知道删除的服务器编码", 4);
			window.location.href = "deleteBaseinfo?sid=" + sid;
			alert("删除成功");
		});

		$("#commit").click(function() {
			alert("添加成功");
		});

		$("#search").click(function() {
			window.location.href = "viewAllBaseinfoupdate";
			alert("查询成功");
		});
	});
	
	function show(sid){
		alert("服务器id："+sid);
		var machinecode =  prompt("请输入服务器编码", "上海服务器");
		var latitude =   prompt("请输入纬度", 31.23 );
		var longitude =   prompt("请输入经度", 121.50);
		var City =   prompt("请输入地址", "上海");
		var machineuser =   prompt("请输入负责人", "王大锤");
		var yys =   prompt("请输入运营商", "中国移动");
		var telephone =   prompt("请输入联系电话", "10086");
		window.location.href="updateBaseinfo?sid="+sid+"&machinecode="+machinecode+"&latitude="+latitude+"&longitude="+longitude+"&City="+City+"&machineuser="+machineuser+"&yys="+yys+"&telephone="+telephone;		
		
	}
</script>
<link rel="stylesheet" type="text/css" href="css/xueshengadd.css" />
<style type="text/css">
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

li {
	display: inline;
}
</style>
</head>
<body>
	<div id="head"></div>
	<table border="0">
		<tr>
			<th scope="col"><a href="../Station/jsp/adminindex.jsp"><img
					src="images/index.png" border="0" width="50" height="50"></a></th>
			<th scope="col"><a href="../Station/jsp/SelectstudentT.jsp"><img
					src="images/fwq.png" border="0" width="50" height="50"></a></th>
			<th scope="col"><a href="../Station/jsp/SelectcourseT.jsp"><img
					src="images/bg.png" border="0" width="50" height="50"></a></th>
			<th scope="col"><a href="../Station/jsp/UpdateteacherT.jsp"><img
					src="images/map.png" border="0" width="50" height="50"></a></th>
			<th scope="col"><a href="../Station/login.html"><img
					src="images/exit.png" border="0" width="50" height="50"></a></th>

		</tr>
		<tr>
			<td><span style="color: blue">信息首页</span></td>
			<td><span style="color: blue">服务器管理</span></td>
			<td><span style="color: blue">excel管理</span></td>
			<td><span style="color: blue">地图显示</span></td>
			<td><span style="color: blue">退出登录</span></td>
		</tr>
	</table>
	<b id="title">基础服务器信息管理：</b>
	<hr />
	<form method="post" action="addBaseinfo" >
		<!-- 图标 -->
		<ul style="float: right">
			<li id="search"><span><img src="images/select.png"
					border="0" width="50" height="50"></span></li>
			<li id="add"><span><img src="images/add.png" border="0"
					width="50" height="50"></span></li>
			<li id="delete"><span><img src="images/delete.png"
					border="0" width="50" height="50"></span></li>
		</ul>
		<br>
		<table width="75%" border="1" align="center" cellpadding="3"
			cellspacing="1" bordercolor="#000000"
			style="border-collapse: collapse">

			<tr>
				<td>站点编号：</td>
				<td><input id="name" name='UserName' type='text' value='' /></td>
			</tr>
			<tr>
				<td>经度：</td>
				<td><input id="xuehao" name='XueHao' type='text' value='' /></td>
			</tr>
			<tr>
				<td>纬度：</td>
				<td><input name='Age' type='text' /></td>
			</tr>
			<tr>
				<td>服务器地址：</td>
				<td>
					<div data-toggle="distpicker" type='text'>
						<select class="form-control" name="Province"></select> <select
							class="form-control" name="City"></select> <select
							class="form-control" name="Town"></select>
					</div>
				</td>
			</tr>
			<tr>
				<td>服务器负责人姓名：</td>
				<td><input name='Classes' type='text' /></td>
			</tr>
			<tr>
				<td>运营商：</td>
				<td><select name="yys" >
                	<option>中国移动</option>
                	<option>中国电信</option>
                	<option>中国联通</option>
          		  	</select>
          		</td>
			</tr>
			<tr>
				<td>Tel：</td>
				<td><input name="telephone" type="text"/></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td><input id="commit" type="submit" value="提交" /> <input
					type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
	<form>
	<table width="75%" border="1" align="center" cellspacing="0"
			cellspacing="1" bordercolor="#000000"
			style="border-collapse: collapse">
			<tr>
				<th>ID</th>
				<th>站址编码</th>
				<th>经纬度</th>
				<th>地址</th>
				<th>服务器负责人</th>
				<th>联系电话</th>
				<th>运营商</th>
				<th>操作</th>
				
			</tr>
			
			<c:forEach items="${list}" var="Station">
				<tr>
					<td>${Station.sid}</td>
					<td>${Station.machinecode}</td>
					<td>${Station.longitude}-${Station.latitude}</td>
					<td>${Station.city}</td>
					<td>${Station.machineuser}</td>
					<td>${Station.telephone}</td>
					<td>${Station.yys}</td>
					<td><a  id = "commit" href = "javascript:void(0)" onclick="show('${Station.sid}')">修改</a></td>
					
				</tr>
			</c:forEach>
		</table>
</form>
	
	
</html>
