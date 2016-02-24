<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
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
function getUrl(){
	$("#dg").attr("url","student!loadStudent.action?random"+new Date().getTime());
}
function rowformater(value,row,index)
{
	return "<a href='loadProject?stuId="+row.stuId+"' target='_blank'>查看</a>";
}
function newUser(){
	$('#dlg').dialog('open').dialog('setTitle','添加用户');
	$('#fm').form('clear');
	url = 'student!addStudent.action';
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
					url:"student!loadStudent.action?random"+new Date().getTime(),
					cache:false,
					method:"post"
				});
			}
		}
	});
}
function doSearch(){
	var name = $("#searchName").val();
	$('#dg').datagrid({
		url:"student!loadStudent.action?stuName="+name+"&ran="+new Date().getTime(),
		cache:false,
		method:"post"
			
	})
	/*var queryParams =$('#dg').datagrid('options').queryParams;  
      getQueryParams(queryParams);  
      $('#dg').datagrid('options').queryParams = queryParams;  
      $("#dg").datagrid('reload'); */
	
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
					<table id="dg" title="学员基本信息" class="easyui-datagrid"
						style="height: 400px" url="" 
						toolbar="#toolbar" pagination="true" rownumbers="true"
						fitColumns="true" singleSelect="true" method="post">
						<thead>
							<tr>
								<th field="stuId" width="50">会员号</th>
								<th field="stuName" width="50">姓名</th>
								<th field="stuPhone" width="50">电话</th>
								<th field="stuAddress" width="50">地址</th>
								<th field="stuMedicalHistory" width="50">病史</th>
								<th field="stuFatherName" width="50">第二联系人</th>
								<th field="stuFatherPhone" width="50">第二联系人电话</th>
								<th data-options="field:'sId',width:20,formatter: rowformater">项目</th>
							</tr>
						</thead>
					</table >
					<script type="text/javascript">
					getUrl()
					</script>
					<div id="toolbar">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							iconCls="icon-add" plain="true" onclick="newUser()">添加</a> <span>
							姓名:</span> <input id="searchName" style="line-height: 26px; border: 1px">
						<a href="#" class="easyui-linkbutton" plain="true"
							iconCls="icon-search" onclick="doSearch()">Search</a>
					</div>
					<div id="dlg" class="easyui-dialog"
						style="width: 400px; height: 280px; padding: 10px 20px"
						closed="true" buttons="#dlg-buttons">
						<div class="ftitle">添加学员</div>
						<form id="fm" method="post">
							<div class="fitem">
								<label>姓名:</label> <input name="stuName"
									class="easyui-validatebox">
							</div>
							<div class="fitem">
								<label>电话:</label> <input name="stuPhone"
									class="easyui-validatebox"
									maxlength="11" 
								onKeyUp="value=value.replace(/\D/g,'')" 
								onafterpaste="value=value.replace(/\D/g,'')">
							</div>
							<div class="fitem">
								<label>地址:</label> <input name="stuAddress">
							</div>
							<div class="fitem">
								<label>病史:</label> <input name="stuMedicalHistory">
							</div>
							<div class="fitem">
								<label>第二联系人:</label> <input name="stuFatherName">
							</div>
							<div class="fitem">
								<label>第二联系人电话:</label> 
								<input name="stuFatherPhone"
								maxlength="11" 
								onKeyUp="value=value.replace(/\D/g,'')" 
								onafterpaste="value=value.replace(/\D/g,'')">
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
				<h2>系统管理</h2>
				<ul>
					<li><a href="index.jsp" class="selected">首页</a></li>
					
				</ul>
				<!--  <h2>我是一个快乐的占位符</h2>
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
				</ul>-->
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>