<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script>
	$.ajaxSetup({
	  global: true,
	  cache: false,
	  async: false
	});
	$(function(){
		$('#dg').datagrid({   
		    url:'findByIds', 
		    fitColumns:true,
		    toolbar: '#tb',
		    pageSize:20,
		    striped:true,
		    title:'我的详细信息',
		    pagination:true,
		    columns:[[   		     
		        {field:'username',title:'用户名',width:80,height:100}, 
		        {field:'currentaddress',title:'住址',width:160,height:100},
		        {field:'nativeplace',title:'籍贯',width:160,height:100},
		        {field:'nickname',title:'昵称',width:80,height:100},
		        {field:'userjob',title:'工作',width:100,height:100},
		        {field:'degree',title:'学历',width:80,height:100},
		        {field:'birthday',title:'生日',width:100,height:100,
		        	formatter: function (value) {
                        var dateMat = new Date(value);
                        var year = dateMat.getFullYear();
                        var month = dateMat.getMonth()+1;
                        var day = dateMat.getDate();
                        return  year + "/" + month + "/" + day;
                    }		        	
			        },
		        {field:'sex',title:'性别',width:80,height:100,formatter: function(value,row,index){
					if (value){
						return '女';
					} else {
						return '男';
					}
				}
				},
				{field:'salary',title:'工资',width:100,height:100},
				{field:'ismarried',title:'婚否',height:100,formatter: function(value,row,index){
					if (value){
						return '已婚';
					} else {
						return '未婚';
					}
				}
				},
				{field:'applypass',title:'支付密码',width:100,height:100},
				{field:'infochecked',title:'审核状态',width:80,height:100,formatter: function(value,row,index){
					if (value){
						return '审核中';
					} else {
						return '通过审核';
					}
				}
				},
				
		        {field:'operate',title:'修改个人信息',width:100,height:100,formatter: function(value,row,index){		        	
		        	var btns= "<a id=\"btn\" href=\"javascript:findById("+row.userinfoid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">修改</a>"; 
					return btns;
				}
				},				
				{
					field : 'operate2',
					title : '我的钱包',
					width : 100,
					height:100,
					formatter : function(value, row, index) {
						var btns = "<a id=\"btn\" href=\"/userinfo/findWalletByUserinfoid/"
								+ row.userinfoid +"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">我的钱包</a>";
						return btns;
					}
				} 
	    ]],
		    onLoadSuccess: function(index,field,value){
				$('.easyui-linkbutton').linkbutton({   
				});  
			}  
		}); 
	})	
	
	function findById(userinfoid){
		$('#ff').form('clear');	// 从URL加载 		
		$('#win').window('open');  // open a window 
			$.getJSON("findById",{userinfoid:userinfoid},function(json){
				$('#ff').form('load',json);	// 从URL加载
				var sex = json.sex?1:0;
				$("input[name='sex'][value="+sex+"]").prop('checked','true');
				var ismarried = json.ismarried?1:0;
				$("input[name='ismarried'][value="+ismarried+"]").prop('checked','true');
				var infochecked = json.infochecked?1:0;
				$("input[name='infochecked'][value="+infochecked+"]").prop('checked','true');
	
				});
		
	}

	function openForm(){
		$('#ff').form('clear');	// 从URL加载 
		$('#win').window('open');  // open a window 
		$("input[name='sex'][value=0]").prop('checked','true');
		$("input[name='ismarried'][value=0]").prop('checked','true');
		$("input[name='infochecked'][value=0]").prop('checked','true');
	}
	function dosave(){
		
		var userinfoid = $("#userinfoid").val();
		var path = "save";
		if(userinfoid!=null&&userinfoid!=""&&userinfoid!=undefined){
			path = "update";
		}
		$('#ff').form('submit', {   
		    url:path,   
		    onSubmit: function(){   
		        // do some check   
		        // return false to prevent submit;   
		    },   
		    success:function(data){   
		       	var json = eval("("+data+")");
		       	$.messager.show({
	    			title:'My Title',
	    			msg:json.msg,
	    			timeout:5000,
	    			showType:'slide'
	    		});
		       	$('#win').window('close');  // open a window 
				$('#dg').datagrid('reload');    // reload the current page data  
		    }   
		}); 
	}
</script>
</head>
<body>
	<table id="dg"></table>
	<div id="win" class="easyui-window" title="My Window"
		style="width: 600px; height: 400px"
		data-options="iconCls:'icon-save',modal:true,closed:true">
		用户详情管理
		<form id="ff" method="post">
		<div>
			 <input type="hidden" name="userinfoid" id="userinfoid">
			
			  <table>
			    <tr>
			      <td>用户ID（此项不可修改）:</td>
			      <td><input class="easyui-validatebox" type="text" readonly="readonly" name="userid"
					data-options="required:true" /></td>			    
			    </tr>
			     <tr>
			      <td>用户名:</td>
			      <td><input class="easyui-validatebox" type="text" name="username"
					data-options="required:true" /></td>			    
			    </tr>
			     <tr>
			      <td>地址:</td>
			      <td><input class="easyui-validatebox" type="text" name="currentaddress"
					data-options="required:true" /></td>			    
			    </tr>
				 <tr>
			      <td>籍贯:</td>
			      <td> <input class="easyui-validatebox" type="text" name="nativeplace"
					data-options="required:true" /></td>			    
			    </tr>
			  
			   <tr>
			      <td>昵称:</td>
			      <td> <input class="easyui-validatebox" type="text" name="nickname"
					data-options="required:true" /></td>			    
			    </tr>
			   <tr>
			      <td>工作:</td>
			      <td> <input class="easyui-validatebox" type="text" name="userjob"
					data-options="required:true" /></td>			    
			    </tr>
			    <tr>
			      <td>学历:</td>
			      <td> <input class="easyui-validatebox" type="text" name="degree"
					data-options="required:true" /></td>			    
			    </tr>
			     <tr>
			      <td>生日:</td>
			      <td>  <input class="easyui-datebox" type="date" name="birthday"
					data-options="required:true" /></td>			    
			    </tr>
			    <tr>
			      <td>性别:</td>
			      <td>  <input type="radio" name="sex"
					value="0">男<input type="radio" name="sex" value="1">女</td>			    
			    </tr>
			    <tr>
			      <td>工资:</td>
			      <td>  <input class="easyui-numberbox" 
			      type="text" name="salary" data-options="required:true" /></td>			    
			    </tr>
			     <tr>
			      <td>婚否:</td>
			      <td>  <input type="radio" name="ismarried"
					value="0">未婚<input type="radio" name="ismarried" value="1">已婚</td>			    
			    </tr>
			    <tr>
			      <td>支付密码:</td>
			      <td>  <input class="easyui-numberbox" type="text" name="applypass"
					data-options="required:true" /></td>			    
			    </tr>
			      <tr>
			      <td>审核状态（此项不可修改）:</td>
			      <td>  <input type="radio" name="infochecked" disabled
					value="0">审核中<input type="radio" name="infochecked" disabled value="1">已通过</td>			    
			    </tr>
			      
			      
			     
			   
			    
		         <tr>
			      <td>确认修改:</td>
			      <td>  <input type="button" onclick="dosave()" value="修改" /></td>			    
			    </tr>
			
			
			  </table>
			</div>
		</form>

	</div>


</body>
</html>