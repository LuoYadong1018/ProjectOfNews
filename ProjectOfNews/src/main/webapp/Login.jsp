<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登陆</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
	  <script type="text/javascript">
	  if(self.location!=top.location) { top.location.href=self.location.href;}
	   function  login(){
		var name=document.getElementById("name").value;   
		var pwd=document.getElementById("pwd").value;   
		  if(name==""  || pwd==""){
			  alert("请输入用户名  和密码 ");
			  return;
		  }   
          document.getElementById("f1").submit();		
	   }
	  </script>
	
</head>
<body>
	<div class="login_head">
		<div class="container">
			<img src="images/logo.png">
		</div>
	</div>

	<div class="login_banner">
		<div class="container">
			<div class="login">
			
			  <form action="userLogin" method="post"  id="f1">
                <div class="login_in">
                    <div class="login_h">后台登陆</div>
                    <div class="user_login">
                        <input type="text"  id="name"  name="user.name"   placeholder="账号">
                        <input type="text"  id="pwd"   name="user.pwd"  placeholder="密码">
                    </div>
                    <div class="login_btn"   onclick="login()">登陆</div>
                </div>
			  </form>
                
            </div>
		</div>
	</div>

	<div class="login_end text_center">版权所有&copy;：新开普电子股份有限公司  豫ICP备08102576号  未经授权本站内容禁止私自转载使用！</div>
</body>
</html>