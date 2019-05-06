<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>excel管理</title>
<link rel="icon" type="image/x-icon" href="images/tubiao.jpg" />
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/distpicker.js"></script>
<script>
$(document).ready(function(){
	  $("#search").click(function(){
		  var offlinetime =  $("#offlinetime").val();
		  var restarttime =  $("#restarttime").val();
		  window.location.href="searchStation?offlinetime="+offlinetime+"&restarttime="+restarttime;
		  alert("查询成功");
	  });
	  
	  $("#add").click(function(){
		  var offlinetime =  $("#offlinetime").val();
		  var restarttime =  $("#restarttime").val();
		  window.location.href="exportStation?offlinetime="+offlinetime+"&restarttime="+restarttime;
		  alert("导出成功");
	  });
	  
	  $("#import").click(function(){ 
		  window.location.href="importStation";
		  alert("导入成功");
	  });
	  
	});
</script>
<link rel="stylesheet" type="text/css" href="css/xueshengadd.css" />
<style type="text/css">
ul
{
list-style-type:none;
margin:0;
padding:0;
}
li
{
display:inline;
}

</style>
</head>
<body>
<div id="head" ></div>
	<table border="0">
			<tr>
				<th scope="col"><a href="../Station/jsp/adminindex.jsp"><img src="images/index.png" border="0" width="50" height="50"></a></th>
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
<b id="title">excel管理：</b> 
		<hr/>
	<!-- 图标 -->
	<ul style="float:right ">
    <li id = "search" ><span><img src="images/select.png" border="0" width="50" height="50"></span></li>
	<li id = "add"><span><img src="images/download.png" border="0" width="50" height="50"></span></li>
	<li id = "import"><span><img src="images/upload.png" border="0" width="50" height="50"></span></li>
	
	</ul>
		<br>
		<table width="75%" border="0" align="center" cellspacing="0"
			cellspacing="1" bordercolor="#000000"
			style="border-collapse: collapse">
			<tr>
				<th>退服时间</th><td><input id="offlinetime" type="date" value="${offlinetime}"/></td>
				<th>恢复时间</th><td><input id="restarttime" type="date" value="${restarttime}"/></td>
			</tr>
		</table>
	<div>
	<p></p>
	</div>
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
				<th>退服时间</th>
				<th>恢复时间</th>
				<th>恢复时长</th>
				<th>记录时间</th>
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
					<td><fmt:formatDate value="${Station.offlinetime}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${Station.restarttime}" pattern="yyyy-MM-dd"/></td>
					<td>${Station.outoflinedate}</td>
					<td><fmt:formatDate value="${Station.updatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</c:forEach>
		</table>
	 
</body>
</html>
