<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>健康之友后台登录</title>
    <script type="text/javascript" src="<%=request.getContextPath() %>/staticfile/dist/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/staticfile/dist/bootstrap.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/staticfile/dist/bootstrap.css">
	<style type="text/css">
	body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,p,form,input,button,textarea,th,td{margin:0;padding:0;border-radius:0;}
	li{text-decoration:none;list-style:none;}
	body{
		height:100%;
		font-size: 62.5%;
		font-family:'Microsoft Yahei','Simsun';	
		background:url(<%=request.getContextPath() %>/staticfile/JKZYimages/adminback.jpg) no-repeat;
		background-size:100%;	
	}
	#login{
		background:rgba(255,255,255,0.3);
		height:75%;
		margin-top:8%;
		padding:0 70px 0 70px;
	}
	form{
		margin-top:50px;	
	}
	#adminname,#password,#submit{
		margin-top:40px;
		border:none;
		border-radius:0;
	}
	#adminname,#password{
		background-color:rgba(255,255,255,0.5);
		color:rgba(0,0,0,1.00)
	}
	
	</style>

	<script type="text/javascript">
		function checkName(){
				var adminName = $("#adminname").val().trim();
				$.ajax({
					'url':'checknamejson',
					'type':'post',
					'dataType':'json',
					'data':{'adminName':adminName},
					'success': 
						function(data){
							if(data==false) {
								alert("此管理员不存在");
								$("#adminname").val("");
							}
						}
				});
			}
			/*ajax实现密码验证后跳转*/
		function checkPassOnSubmit(){
			var adminName = $("#adminname").val().trim();
			var password = $("#password").val().trim();
			var flag = true;
			$.ajax({
					'url':'checkpassjson',
					'type':'post',
					'dataType':'json',
					async:false,//注意同步方式必须更改
					'data':{
						'adminName':adminName,
						'password':password
					},
					'success': 
						function(data){
							if(data==false) {
								alert("密码错误，请重新输入");
								$("#password").val("");
								flag=false;
							}
						}
				});
				if(adminName==""){
					alert("请输入用户名和密码");
					return false;
				}
			if(!flag)
				return false;	
			
		}
		
		
	</script>
  </head>
  
  <body>
    <div class="row">
    	<div class="col-xs-4 col-xs-offset-4" id="login">
    	 
        	<h1 style="color:#1cb394; font-family:Impact; font-weight:bolder; font-size:38px;text-align:center; margin-top:40px;">
        	<img src="<%=request.getContextPath() %>/staticfile/JKZYimages/logo_t_u16.png" ><br/>后台管理系统</h1>
        	<h4 style="color:white; text-align:center;margin-top:20px;">登录</h4>
        	<form class="form-horizontal"  method="post" action="<%=request.getContextPath() %>/admin/login">	
            	<input type="text" class="form-control" name="adminname" id="adminname" placeholder="用户名" onchange="checkName()"/>
                <input type="password"  class="form-control" name="password" id="password" placeholder="密码">
                <input type="submit" value="登录" class="form-control"; id="submit"
                				style="background-color:#1cb394; color:white; margin-top:50px;"
                				onclick="return checkPassOnSubmit()">
            </form>
        	<div style="text-align:center; margin-top:15px;"><a style="color:white;">忘记密码？</a></div>
        </div> 
    </div>
  </body>
</html>
