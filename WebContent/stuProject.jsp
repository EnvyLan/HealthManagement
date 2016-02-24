<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学员项目信息查看</title>
<link rel="stylesheet" type="text/css" href="css/indexstyle.css" />
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<link rel="stylesheet" type="text/css" href="themes/color.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<link rel="stylesheet" type="text/css" href="css/dialog.css">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<script type="text/javascript">
function rowformater(value,row,index)
{
	var stuid = $("#stuid_hidden").val()
	return " <a href='loadProject!loadRecord.action?projectId=" +row.projectId+ " &stuId="+stuid+" 'target='_blank'>查看</a>";
}
function newUser(){
	
	$('#dlg').dialog('open').dialog('setTitle','添加用户项目');
	$('#fm').form('clear');
	url = 'loadProject!addStudentProject.action?stuId='+$("#stuid_hidden").val();
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
					url:$("#dg").attr("url").val()+"&ran="+new Date().getTime(),
					cache:false
				});
			}
		}
	});
}
</script>
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
						value="<%=ActionContext.getContext().get("stuId") %>">
					<table id="dg" title="项目基本信息" class="easyui-datagrid"
						style="height: 400px" method="post"
						url="loadProject!searchStuProject.action?stuId=<%=ActionContext.getContext().get("stuId") %>"
						toolbar="#toolbar" pagination="true" rownumbers="true"
						fitColumns="true" singleSelect="true">
						<thead>
							<tr>
								<th field="projectId" width="50">项目编号</th>
								<th field="projectName" width="50">项目名称</th>
								<th field="projectLevel" width="50">项目等级</th>
								<th field="projectTeacher" width="50">教练</th>
								<th field="projectAddress" width="50">地址</th>
								<th data-options="field:'sId',width:20,formatter: rowformater">记录</th>
							</tr>
						</thead>
					</table>
					<div id="toolbar">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
					</div>
					<div id="dlg" class="easyui-dialog"
						style="width: 400px; height: 280px; padding: 10px 20px"
						closed="true" buttons="#dlg-buttons">
						<div class="ftitle">添加项目</div>
						<form id="fm" method="post">
							<div class="fitem">
								<label>项目名称:</label> <input name="projectName"
									class="easyui-validatebox">
							</div>
							<div class="fitem">
								<label>项目等级:</label> <input name="projectLevel"
									class="easyui-validatebox">
							</div>
							<div class="fitem">
								<label>教练:</label> <input name="projectTeacher">
							</div>
							<div class="fitem">
								<label>地址:</label> <input name="projectAddress">
							</div>
						</form>
					</div>
					<div id="dlg-buttons">
						<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
							onclick="saveUser()">Save</a> <a href="#"
							class="easyui-linkbutton" iconCls="icon-cancel"
							onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
					</div>
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