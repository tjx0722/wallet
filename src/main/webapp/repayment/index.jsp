<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

<body>
	<div class="panel panel-default">
		<div class="panel-body">
			<ul class="nav nav-pills">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Messages</a></li>
			</ul>
		</div>

		<table class="table table-hover" id="antzone">
			<thead>
				<tr align="center">
					<td><b><h3>订单号</h3></b>
					</th>
					<td><b><h3>交易时间</h3></b>
					</th>
					<td><b><h3>借款金额</h3></b>
					</th>
					<td><b><h3>借款原因</h3></b>
					</th>
					<td><b><h3>订单状态</h3></b>
					</th>
					<td><b><h3>详情查看</h3></b>
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="loanapply">
					<tr align="center">
						<td>${loanapply.loanapplyid}</td>
						<td><fmt:formatDate value="${loanapply.applytime}"
								pattern="yyyy/MM/dd  HH:mm:ss" /></td>
						<td>${loanapply.loanamount }</td>
						<td>${loanapply.reason }</td>
						<td>${loanapply.checked==false?'审核中':'已通过'}</td>
						<td><span id="sy" data-container="body" data-toggle="popover"
							data-trigger="click" data-placement="top"
							data-content='客官莫急,该笔交易还在审核中'
							onclick="fun2(${loanapply.checked},${loanapply.loanapplyid})"
							class="glyphicon glyphicon-eye-open"></span></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body">
					<table class="table table-hover" id="modeltable">
						<thead>
							<tr>
								<th>数据类型</th>
								<th>订单详情</th>
							</tr>
						</thead>
						<tbody id="tbody">
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
<script>
$(function (){
    $("[data-toggle='popover']").popover();
});



var s='${json }';
var json=JSON.parse(s);

function getJsonLength(jsonData) {
	var length=0;
	for(var ever in jsonData) {
	    length++;
	}
	return length;
};


Date.prototype.toLocaleString = function() {
    function addZero(num) {
        if(num<10)
            return "0" + num;
        return num;
    }
    return this.getFullYear() + "/" + addZero(this.getMonth() + 1) + "/" + addZero(this.getDate()) + " " +
        addZero(this.getHours()) + ":" + addZero(this.getMinutes()) + ":" + addZero(this.getSeconds());
};

function fun2(obj1,obj2){
	 if(obj1==true ){
		 $('#sy').popover('destroy');
		fun1(obj2);
	 }};
function fun1(obj){
	
	var length=getJsonLength(json);
	console.log(json);
	for (var i = 0; i < length; i++) {
		 if(obj==json[i].loanapplyid){
				var j=json[i];
		}
	};
	var test =j.allRepays;
	var length2=getJsonLength(test);
	var hasrestamount=0;
	var count2=0;
	var restamount=0;
	var count3=new Date().getTime()+30* 1000*60*60*24;
	var count5=new Date().getTime();
	 for (var i = 0; i < length2; i++) {
		 if(test[i].isfinished==true){
			var a=test[i].restamount;
			count2++;
			hasrestamount=hasrestamount+a;
			}else{
				var b=test[i].restamount;
				restamount=restamount+b;
				if(test[i].repaytime<count3){
					count3=test[i].repaytime;
				}
				if(test[i].repaytime>count5){
					count5=test[i].repaytime;
					}
			}
		} 
	var newDate = new Date(j.applytime ); 
	var dateTime = newDate.toLocaleString();
	var newDate2 = new Date(count3 ); 
	var count4=newDate2.toLocaleString();
	var newDate3 = new Date(count5 ); 
	var count5=newDate3.toLocaleString();
	$("#tbody").empty();
	var oTab = document.getElementById('modeltable');
	 var oTbody = oTab.tBodies[0];
			var oTr1 = document.createElement('tr');
		    oTbody.appendChild(oTr1);
		    var oTd11 = document.createElement('td');
		    var oTd12 = document.createElement('td');
		    oTd11.innerHTML = "申请时间";
		    oTd12.innerHTML = dateTime;
		    oTr1.appendChild(oTd11);
		    oTr1.appendChild(oTd12);

		     

		    var oTr3 = document.createElement('tr');
		    oTbody.appendChild(oTr3);
		    var oTd31 = document.createElement('td');
		    var oTd32 = document.createElement('td');
		    oTd31.innerHTML = "贷款金额";
		    oTd32.innerHTML = j.loanamount;
		    oTr3.appendChild(oTd31);
		    oTr3.appendChild(oTd32); 


		    var oTr2 = document.createElement('tr');
		    oTbody.appendChild(oTr2);
		    var oTd21 = document.createElement('td');
		    var oTd22 = document.createElement('td');
		    oTd21.innerHTML = "申请原因";
		    oTd22.innerHTML = j.reason;
		    oTr2.appendChild(oTd21);
		    oTr2.appendChild(oTd22); 

		    var oTr4 = document.createElement('tr');
		    oTbody.appendChild(oTr4);
		    var oTd41 = document.createElement('td');
		    var oTd42 = document.createElement('td');
		    oTd41.innerHTML = "分期月数";
		    oTd42.innerHTML = j.loantime.loantime;
		    oTr4.appendChild(oTd41);
		    oTr4.appendChild(oTd42);


		    var oTr6 = document.createElement('tr');
		    oTbody.appendChild(oTr6);
		    var oTd61 = document.createElement('td');
		    var oTd62 = document.createElement('td');
		    oTd61.innerHTML = "已还钱数";
		    oTd62.innerHTML = parseInt(hasrestamount);
		    oTr6.appendChild(oTd61);
		    oTr6.appendChild(oTd62);
		    
		    var oTr10 = document.createElement('tr');
		    oTbody.appendChild(oTr10);
		    var oTd101 = document.createElement('td');
		    var oTd102 = document.createElement('td');
		    oTd101.innerHTML = "剩余待还钱数";
		    oTd102.innerHTML = parseInt(restamount);
		    oTr10.appendChild(oTd101);
		    oTr10.appendChild(oTd102);

		    var oTr7 = document.createElement('tr');
		    oTbody.appendChild(oTr7);
		    var oTd71 = document.createElement('td');
		    var oTd72 = document.createElement('td');
		    oTd71.innerHTML = "剩余待还期限数";
		    oTd72.innerHTML = j.loantime.loantime-count2;
		    oTr7.appendChild(oTd71);
		    oTr7.appendChild(oTd72);

		    var oTr8 = document.createElement('tr');
		    oTbody.appendChild(oTr8);
		    var oTd81 = document.createElement('td');
		    var oTd82 = document.createElement('td');
		    oTd81.innerHTML = "下次还款期限";
		    oTd82.innerHTML = count4;
		    oTr8.appendChild(oTd81);
		    oTr8.appendChild(oTd82);

		    var oTr9 = document.createElement('tr');
		    oTbody.appendChild(oTr9);
		    var oTd91 = document.createElement('td');
		    var oTd92 = document.createElement('td');
		    oTd91.innerHTML = "最后还款期限";
		    oTd92.innerHTML = count5;
		    oTr9.appendChild(oTd91);
		    oTr9.appendChild(oTd92);
		    
		    var oTr5 = document.createElement('tr');
		    oTbody.appendChild(oTr5);
		    var oTd51 = document.createElement('td');
		    var oTd52 = document.createElement('td');
		    oTd51.innerHTML = "交易手续费";
		    oTd52.innerHTML = j.servicecharge;
		    oTr5.appendChild(oTd51);
		    oTr5.appendChild(oTd52);

		    
	 $('#myModal').modal({
		 
		})
}

</script>



