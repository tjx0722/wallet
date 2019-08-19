<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script>
	$.ajaxSetup({
	  global: true,
	  cache: false,
	  async: false
	});


	$(function(){
		$('#dg').datagrid({   
		    url:'findAll', 
		    fitColumns:true,
		    toolbar: '#tb',
		    pageSize:20,
		    striped:true,
		    title:'银行卡信息管理',
		    pagination:true,
		    columns:[[   
		    	{field:'bankcardid',checkbox:'checkbox',title:'编号'},      
		    	
		        {field:'bankcardnum',title:'银行卡号'},   
		        {field:'bankcardname',title:'银行名称'}, 
		        {field:'walletid',title:'钱包id'},
		       
		        {field:'operate',title:'操作',width:100,formatter: function(value,row,index){
		        	var btns = "<a id=\"btn\" href=\"javascript:deleteItem("+row.stid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">删除</a>";
		        	btns += "<a id=\"btn\" href=\"javascript:findById("+row.stid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">修改</a>"; 
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
	
	function deleteItem(bankcardid){
		$.messager.confirm('Confirm','Are you sure you want to delete record?',function(r){   
		    if (r){   
		    	$.getJSON("delete",{bankcardid:bankcardid},function(json){
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
		var bankcardidstring = "";
		var selections = $('#dg').datagrid('getSelections');  // fix the 'name' column size
		for(var i=0;i<selections.length;i++)
		{
			bankcardidstring += selections[i].bankcardid;
			if(i<selections.length-1)
				bankcardidstring +=",";
		}
		
		$.getJSON("deleteBatch",{bankcardidstring:bankcardidstring},function(json){
			$.messager.show({
    			title:'My Title',
    			msg:json.msg,
    			timeout:5000,
    			showType:'slide'
    		});
			$('#dg').datagrid('reload');    // reload the current page data  
		});
	}
	
	function findById(bankcardid){
		$('#ff').form('clear');	// 从URL加载 		
		$('#win').window('open');  // open a window 
			$.getJSON("findById",{bankcardid:bankcardid},function(json){
				$('#ff').form('load',json);	// 从URL加载
				var sex = json.stsex?1:0;
				$("input[name='sex'][value="+sex+"]").prop('checked','true');
			});
		
	}
	
	function openForm(){
		$('#ff').form('clear');	// 从URL加载 
		$('#win').window('open');  // open a window 
		$("input[name='sx'][value=0]").prop('checked','true');
	}
	
	function dosave(){
		var bankcardid = $("#bankcardid").val();
		var path = "save";
		if(bankcardid!=null&&bankcardid!=""&&bankcardid!=undefined){
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
<a href="javascript:deleteBatch()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
<a href="javascript:openForm()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">增加</a>
</div>

<div id="win" class="easyui-window" title="My Window" style="width:600px;height:400px"  
        data-options="iconCls:'icon-save',modal:true,closed:true">  
    	银行卡管理
    	<form id="ff" method="post">  
    	<input type="hidden" name="bankcardid" id="bankcardid">
	    <div>  
	        <label for="bankcardnum">balance:</label>  
	        <input class="easyui-validatebox" type="text" name="bankcardnum" data-options="required:true" />  
	    </div>  
	     <div>  
	        <label for="bankcardname">debt:</label>  
	        <input class="easyui-validatebox" type="text" name="bankcardname" data-options="required:true" />  
	    </div>  
	    <div>  
	        <label for="walletid">userinfoid:</label>  
	        <input class="easyui-numberbox" type="text" name="walletid" data-options="required:true" />  
	    </div>   
	    <div>  
	            <input type="button" onclick="dosave()" value="保存" />  
	    </div> 
	</form>  
    	   
</div>  


</body>
</html>