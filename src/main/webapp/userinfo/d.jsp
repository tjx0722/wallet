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
		    title:'用户详细信息管理',
		    pagination:true,
		    columns:[[   
		    	
     
		    	
		        {field:'userid',title:'用户id'},   
		        {field:'username',title:'用户名'}, 
		        {field:'currentaddress',title:'住址'},
		        {field:'nativeplace',title:'籍贯'},
		        {field:'usericon',title:'头像'},
		        {field:'nickname',title:'昵称'},
		        {field:'userjob',title:'工作'},
		        {field:'degree',title:'学历'},
		        {field:'birthday',title:'生日',
		        	formatter: function (value) {
                        var dateMat = new Date(value);
                        var year = dateMat.getFullYear();
                        var month = dateMat.getMonth()+1;
                        var day = dateMat.getDate();
                        return  year + "/" + month + "/" + day;
                    }
		        	
			        },
		        {field:'sex',title:'性别',formatter: function(value,row,index){
					if (value){
						return '女';
					} else {
						return '男';
					}
				}
				},
				{field:'salary',title:'工资'},
				{field:'ismarried',title:'婚否',formatter: function(value,row,index){
					if (value){
						return '已婚';
					} else {
						return '未婚';
					}
				}
				},
				{field:'isfochecked',title:'审核是否通过'},
		        {field:'operate',title:'操作',width:100,formatter: function(value,row,index){
		        	var btns = "<a id=\"btn\" href=\"javascript:deleteItem("+row.userinfoid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">删除</a>";
		        	btns += "<a id=\"btn\" href=\"javascript:findById("+row.userinfoid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">修改</a>"; 
					return btns;
				}
				},
				{
					field : 'operate2',
					title : '操作',
					width : 100,
					formatter : function(value, row, index) {
						var btns = "<a id=\"btn\" href=\"/userinfo/findWalletByUserinfoid/"
								+ row.userinfoid +"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">钱包</a>";
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
	
	function deleteItem(userinfoid){
		$.messager.confirm('Confirm','Are you sure you want to delete record?',function(r){   
		    if (r){   
		    	$.getJSON("delete",{userinfoid:userinfoid},function(json){
		    		$.messager.show({
		    			title:'My Title',
		    			msg:json.msg,
		    			timeout:5000,
		    			showType:'slide'
		    		});
					$('#dg').datagrid('reload');    // reload the current page data  
				});
		    }   
		});  
		
	}
	
	function deleteBatch(){
		var userinfoidstring = "";
		var selections = $('#dg').datagrid('getSelections');  // fix the 'name' column size
		for(var i=0;i<selections.length;i++)
		{
			userinfoidstring += selections[i].userinfoid;
			if(i<selections.length-1)
				userinfoidstring +=",";
		}
		
		$.getJSON("deleteBatch",{userinfoidstring:userinfoidstring},function(json){
			$.messager.show({
    			title:'My Title',
    			msg:json.msg,
    			timeout:5000,
    			showType:'slide'
    		});
			$('#dg').datagrid('reload');    // reload the current page data  
		});
	}
	
	function findById(userinfoid){
		$('#ff').form('clear');	// 从URL加载 		
		$('#win').window('open');  // open a window 
			$.getJSON("findById",{userinfoid:userinfoid},function(json){
				$('#ff').form('load',json);	// 从URL加载
				var sex = json.sex?1:0;
				$("input[name='sex'][value="+sex+"]").prop('checked','true');
			});
		
	}

	function openForm(){
		$('#ff').form('clear');	// 从URL加载 
		$('#win').window('open');  // open a window 
		$("input[name='sex'][value=0]").prop('checked','true');
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


	<div id="tb">
		<a href="javascript:deleteBatch()" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true">批量删除</a> <a
			href="javascript:openForm()" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true">增加</a>
	</div>

	<div id="win" class="easyui-window" title="My Window"
		style="width: 600px; height: 400px"
		data-options="iconCls:'icon-save',modal:true,closed:true">
		用户详情管理
		<form id="ff" method="post">
			<input type="hidden" name="userinfoid" id="userinfoid">
			<div>
				<label for="userid">userid:</label> <input
					class="easyui-validatebox" type="text" name="userid"
					data-options="required:true" />
			</div>
			<div>
				<label for="username">username:</label> <input
					class="easyui-validatebox" type="text" name="username"
					data-options="required:true" />
			</div>
			<div>
				<label for="currentaddress">currentaddress:</label> <input
					class="easyui-validatebox" type="text" name="currentaddress"
					data-options="required:true" />
			</div>
			<div>
				<label for="nativeplace">nativeplace:</label> <input
					class="easyui-validatebox" type="text" name="nativeplace"
					data-options="required:true" />
			</div>
			<div>
				<label for="usericon">usericon:</label> <input
					class="easyui-validatebox" type="text" name="usericon"
					data-options="required:true" />
			</div>
			<div>
				<label for="nickname">nickname:</label> <input
					class="easyui-validatebox" type="text" name="nickname"
					data-options="required:true" />
			</div>
			<div>
				<label for="userjob">userjob:</label> <input
					class="easyui-validatebox" type="text" name="userjob"
					data-options="required:true" />
			</div>
			<div>
				<label for="degree">degree:</label> <input
					class="easyui-validatebox" type="text" name="degree"
					data-options="required:true" />
			</div>
			<div>
				<label for="birthday">birthday:</label> <input
					class="easyui-datebox" type="date" name="birthday"
					data-options="required:true" />
			</div>
			<div>
				<label for="sex">sex:</label> <input type="radio" name="sex"
					value="0">男<input type="radio" name="sex" value="1">女
			</div>
			<div>
				<label for="salary">salary:</label> <input class="easyui-numberbox"
					type="text" name="salary" data-options="required:true" />
			</div>
			<div>
				<label for="ismarried">ismarried:</label> <input
					class="easyui-numberbox" type="text" name="ismarried"
					data-options="required:true" />
			</div>
			<div>
				<label for="infochecked">infochecked:</label> <input
					class="easyui-numberbox" type="text" name="infochecked"
					data-options="required:true" />
			</div>
			<div>
				<input type="button" onclick="dosave()" value="保存" />
			</div>
		</form>

	</div>


</body>
</html>