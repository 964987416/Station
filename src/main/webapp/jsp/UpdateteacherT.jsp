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
<title>地图显示</title>
<link rel="icon" type="image/x-icon" href="images/tubiao.jpg" />
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/distpicker.js"></script>
<script>
$(document).ready(function(){
	  $("#delete").click(function(){
		  var code = prompt("请输入你想知道删除的教师编码",001);
		  window.location.href="deleteTeacher?code="+code;
		  alert("删除成功");
	  });
	  
	  $("#commit").click(function(){
		  alert("添加成功");
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

<!-- 百度地图接口 -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#allmap{height:500px;width:100%;}
		#r-result{width:100%; font-size:14px;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=WSfGPxOIrso96tQy0cU6YYv5F8ebAL57"></script>



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
<b id="title">地图显示：</b> 
		<hr/>
	<div id="r-result">
		经度: <input id="longitude" type="text" style="width:100px; margin-right:10px;"  value="121.50"/>
		纬度: <input id="latitude" type="text" style="width:100px; margin-right:10px;" value = "31.23"/>
		<input type="button" value="查询" onclick="theLocation()" />
		
	</div>
			<div id="allmap"></div>
	<table width="75%" border="" align="center" cellspacing="0"
			
			style="border-collapse: collapse">
			<c:forEach items="${list}" var="Station">
				<tr>
					<td>${Station.machinecode}</td>
					<td>${Station.longitude},${Station.latitude}</td>
				</tr>
			</c:forEach>
		</table> 
	
	
	
	
</body>
</html>
<script type="text/javascript">
	 // 百度地图API功能
	var map = new BMap.Map("allmap");
	map.centerAndZoom(new BMap.Point(116.331398,39.897445),9);
	map.enableScrollWheelZoom(true);
	// 用经纬度设置地图中心点
	function theLocation(){
		if(document.getElementById("longitude").value != "" && document.getElementById("latitude").value != ""){
			map.clearOverlays(); 
			var new_point = new BMap.Point(document.getElementById("longitude").value,document.getElementById("latitude").value);
			var marker = new BMap.Marker(new_point);  // 创建标注
			map.addOverlay(marker);              // 将标注添加到地图中
			map.panTo(new_point);      
		}
	}
	
</script>
