function setRole (role,text,id,username){
	$(("#s_"+id)).html(text);
	
	$.ajax({
		url: basePath+"user/setRole?userid="+id+"&roleid="+role,
		type: 'POST',
		data: {
			method: "update",
			roleId:role,
			loginId:id,
			username:username
		},
		success: function(data){
			console.info(data);
			var pText = document.getElementById("alertOKText");
			pText.innerText = "权限更改";
			$("#alertOK").modal();
//			window.location="user?method=users";
//			if(data.success) {
//				
//			}else{
//				var pText = document.getElementById("alertOKText");
//				pText.innerText = "权限非正常修改，请联系管理员";
//				$("#alertOK").modal();
//			}
		},
		error: function(){
			alert ('服务器问题。');
		}
		});
	
}
$("#closeBtn").click( function () { 
	
	close();
});
function close() {
	window.location="toUser";
}

function delModal (login_id){
	$("#temoLoginId").val(login_id);
	$("#delModal").modal();
	
}

function deleteUser (){
	
	var temoLoginId = $("#temoLoginId").val();
	$.ajax({
		url:basePath+"user/deleteUser?id="+temoLoginId,
		type:'post',
		success:function (data){
			// 重新请求一个url
			window.location = "toUser";
		}
	});
}