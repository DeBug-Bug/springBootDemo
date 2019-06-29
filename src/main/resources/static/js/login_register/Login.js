
function loginValidate(){
	var account=$("#account").val();
	var password=$("#password").val();	
	if(account==""||account.length==0){
		alert("请输入账号！");
	}else{
		if(password==""||password.length==0){
			alert("请输入密码！");
		}else{
			 $.ajax({
				 type:"POST",
				 url:"/springBootDemo/login/loginValidate?account="+account+"&password="+password,
				 dataType: "json",
				 success:function (result) {
				 	console.log(result);
					 if(result==200)
						 window.location.href="/springBootDemo/view/index.html";
					 else
						 alert("登录失败");
				 }
			 });
		}
	}
}