<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学员项目记录表查看</title>
<link rel="stylesheet" type="text/css" href="css/indexstyle.css" />
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<link rel="stylesheet" type="text/css" href="themes/color.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<link rel="stylesheet" type="text/css" href="css/dialog.css">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
<script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>
<script type="text/javascript" src="js/chart.js"></script>
<script type="text/javascript">
function getUrl(){
	var stuid = $("#stuid_hidden").val();
	var projectId = $("#projectId_hidden").val();
	tableUrl = "loadProject!searchStuProjectRecord.action?projectId="+projectId+"&stuId="+stuid;
	$("#dg").attr("url", tableUrl)
}

function newUser(){
	$('#dlg').dialog('open').dialog('setTitle','添加运动记录');
	var stuid = $("#stuid_hidden").val();
	var projectId = $("#projectId_hidden").val();
	$('#fm').form('clear');
	url = 'addRecord!addProjectRecord.action?stuId='+stuid+'&projectId='+projectId;
}
function saveUser(){
	$('#fm').form('submit',{
		url:url,
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function(result){
			var result=eval('('+result+')');
			if(result.errorMsg){
				$.messager.alert("系统提示",result.errorMsg);
				return;
			}else{
				$.messager.alert("系统提示","保存成功");
				$('#dlg').dialog('close');
				$("#dg").datagrid({
					url:$("#dg").attr("url")+"&ran="+new Date().getTime(),
					cache:false,
					method:"post"
				});
			}
		}
	});
}
</script>
</head>
<body>
	<div id="panelwrap">
		<div class="header">
			<div class="title">
				<a href="#">健康运动成长记录系统</a>
			</div>
			<div class="header_right">
				Welcome 赵指导, <a href="#" class="settings">Settings</a> <a href="#"
					class="logout">Logout</a>
			</div>
		</div>
		<div class="center_content">
			<div id="right_wrap">
				<div id="right_content">
					<h2></h2>
					<input id="stuid_hidden" name="stuId" type="hidden"
						value="<%=ActionContext.getContext().get("stuId") %>"> <input
						id="projectId_hidden" name="projectId" type="hidden"
						value="<%=ActionContext.getContext().get("projectId") %>">
					<table id="dg" title="项目训练记录" class="easyui-datagrid"
						style="height: 400px" url="" toolbar="#toolbar" pagination="true"
						rownumbers="true" singleSelect="true" method="post">
						<thead>
							<tr>
								<th field="formatDate" width="80">记录时间</th>
								<th field="stuHeight" width="60"><a href="#" onclick="updateChart('身高','cm','stuHeight')">身高(cm)</a></th>
								<th field="stuWeight" width="60">体重(kg)</th>
								<th field="stu100mSpeed" width="80">百米速度(s)</th>
								<th field="stuArmSize" width="80">臂展(cm)</th>
								<th field="stuRunBack" width="90">全场折返跑(s)</th>
								<th field="stuRunWithBall" width="90">带球折返跑(s)</th>
								<th field="stuToughHeight" width="60">摸高(cm)</th>
								<th field="stuResponseTime" width="80">反应度(ms)</th>
								<th field="stuHandSize" width="80">手掌大小(㎡)</th>
								<th field="stuJump" width="90">连续垂直跳(次)</th>
								<th field="stuShootBall" width="90">1分钟投抢(个)</th>
								<th field="stuHeart" width="100">心肺功能(单位待定)</th>
								<th field="stuGrade" width="80" ><a href="#" onclick="updateChart('评分','分','stuGrade')">评分</a></th>
							</tr>
						</thead>
					</table>
					<div id="toolbar">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							iconCls="icon-add" plain="true" onclick="newUser()">添加</a> <a
							href="javascript:void(0)" class="easyui-linkbutton"
							iconCls="icon-large-chart" plain="true"
							onclick="updateChart('评分', '分')">评分折线图</a>
					</div>
					<div id="dlg" class="easyui-dialog"
						style="width: 400px; height: 480px; padding: 10px 20px"
						closed="true" buttons="#dlg-buttons">
						<div class="ftitle">添加运动记录</div>
						<form id="fm" method="post">
							<script type="text/javascript">getUrl()</script>
							<div class="fitem">
								<label>身高:</label> <input name="stuHeight"
									class="easyui-validatebox" 
									onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
							<div class="fitem">
								<label>体重:</label> <input name="stuWeight"
									class="easyui-validatebox"
									onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
							<div class="fitem">
								<label>百米速度:</label> <input name="stu100mSpeed"
												onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
							<div class="fitem">
								<label>摸高:</label> <input name="stuTouchHeight"
								onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
							<div class="fitem">
								<label>臂展:</label> <input name="stuArmSize"
								onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
							<div class="fitem">
								<label>折返跑:</label> <input name="stuRunBack"
								onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
							<div class="fitem">
								<label>带球全场跑:</label> <input name="stuRunWithBall"
									class="easyui-validatebox"
									onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
							<div class="fitem">
								<label>反应灵敏度:</label> <input name="stuResponseTime"
									class="easyui-validatebox"
									onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
							<div class="fitem">
								<label>手掌大小:</label> 
								<input name="stuHandSize"
								onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
							<div class="fitem">
								<label>连续垂直跳:</label> 
								<input name="stuJump"
								onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
							<div class="fitem">
								<label>1分钟自投自抢:</label> 
								<input name="stuShootBall"
								onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
							<div class="fitem">
								<label>心肺功能:</label> 
								<input name="stuHeart"
								onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
							<div class="fitem">
								<label>评分:</label>
								 <input name="stuGrade"
								 onkeyup="if(isNaN(value))execCommand('undo')" 
									onafterpaste="if(isNaN(value))execCommand('undo')">
							</div>
						</form>
					</div>
					<div id="dlg-buttons">
						<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
							onclick="saveUser()">Save</a> <a href="#"
							class="easyui-linkbutton" iconCls="icon-cancel"
							onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
					</div>
					<div id="container"
						style="min-width: 310px; height: 400px; margin: 0 auto"></div>
				</div>
			</div>
			<!-- end of right content-->
			<div class="sidebar" id="sidebar">
				<h2>我是一个快乐的占位符</h2>
				<ul>
					<li><a href="index.jsp" class="selected">首页</a></li>
					<li><a href="#">我是一个快乐的占位符</a></li>
					<li><a href="#">我是一个快乐的占位符</a></li>
					<li><a href="#">我是一个快乐的占位符</a></li>
					<li><a href="#">我是一个快乐的占位符</a></li>
					<li><a href="#">我是一个快乐的占位符</a></li>
				</ul>
				<h2>我是一个快乐的占位符</h2>
				<ul>
					<li><a href="#">我是一个快乐的占位符</a></li>
					<li><a href="#">我是一个快乐的占位符</a></li>

				</ul>
				<h2>我是一个快乐的占位符</h2>
				<ul>
					<li><a href="#">我是一个快乐的占位符</a></li>
					<li><a href="#">我是一个快乐的占位符</a></li>
					<li><a href="#">我是一个快乐的占位符</a></li>
					<li><a href="#">我是一个快乐的占位符</a></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>