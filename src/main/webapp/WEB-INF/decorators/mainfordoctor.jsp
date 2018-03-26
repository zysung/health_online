<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><sitemesh:write property='title' /></title>
    <script type="text/javascript" src="<%=request.getContextPath() %>/staticfile/dist/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/staticfile/dist/bootstrap.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/staticfile/dist/bootstrap.css">
      <sitemesh:write property='head' />
	
    <style type="text/css">
	body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,p,form,input,button,textarea,th,td{margin:0;padding:0;border:0;border-radius:0;}
	a,li{text-decoration:none;list-style:none; }
	a:hover,a:visited,a:link,a:active{
		text-decoration:none;list-style:none;
	}
	body{
		height:100%;
		font-size: 62.5%;
		font-family:'Microsoft Yahei','Simsun';		
	}
	.navbar{
		font-size:14px;
		margin:0;
		border-radius:0;
	}
	#left_nav{
		height:100%;
		overflow:auto;
		padding:0;
		background:#e7e7e7;
		border-right:1px solid #1cb394;
	}
	.panel-body{
		padding:0;
	}

	.panel{
		border-radius:0;
		border-right:0;
		padding-left:10px;
	}	
	.panel-heading{
		
	}
	.panel-body ul li{
		height:30px;
		line-height:30px;
		font-size:14px;
		width:100%;
		overflow:hidden;
		
	}
	.panel-body ul li:hover,.panel-body ul li a:hover{
		background:#1cb394;
		color:white;
	}
	.panel-body ul li a{
		margin-left:20px;
		display:block;
		color:black;
	}
	#content{
		margin-top: 20px;
    	padding-right: 30px;
	}
	.footer{
		padding-top:5px;
		position:relative;
		top:0;
		height:100px;
		background:rgba(56,56,56,1.00);
		color:#ffffff;
	}
</style>


  </head>

  <body>
    <div style="doctorground:#1cb394; width:100%; height:5px;"></div>
	<nav class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/doctor/users" style="font-family:Impact; font-weight:bolder; font-size:25px;color:#1cb394;">
			JKZY&nbsp;后台管理系统</a>
  		</div>    
        <div class="collapse navbar-collapse">
     	   	<ul class="nav navbar-nav">
      			<li class="active"><!-- <a href="#">主页</a> --></li>
        	</ul>
        	<ul class="nav navbar-nav navbar-right">
      			<li><a href="www.baidu.com">关于我们</a></li>
      			<li><a>当前管理员:${loginAdmin.account}</a></li>
      			<li>	<a href="<%=request.getContextPath()%>/admin/logout" style="color:red;">退出登录</a></li>
            </ul>
        </div>
  	</nav>
    
 	<div class="row" style="height: 100%;">
    	<div class="col-xs-2" id="left_nav">
			<div class="panel-group" id="accordion" style="margin-top:5px;">
              <div class="panel panel-default" style="border-radius:0;">
                <div class="panel-heading" data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                     	健康数据管理
                    </a>
                  </h4>
                </div>
                <div id="collapse2" class="panel-collapse collapse in">
                  <div class="panel-body">
                   	<ul>
                  		<li style="border-bottom:1px solid #1cb394"><a href="<%=request.getContextPath()%>/doctor/data/userstosportdatas">运动数据</a></li>
                        <li ><a href="<%=request.getContextPath()%>/doctor/data/userstocustodydatas">监护数据</a></li>
                    </ul>      
                  </div>
                </div>
              </div>
              <div class="panel panel-default" style="border-radius:0;">
                  <div class="panel-heading" data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                     	合作医院管理
                    </a>
                  </h4>
                  </div>
                <div id="collapse3" class="panel-collapse collapse in">
                  <div class="panel-body">
                   	<ul>
                  		<li style="border-bottom:1px solid #1cb394"><a href="<%=request.getContextPath()%>/doctor/hospital/hospitals">医院资料</a></li>
                        <li ><a href="<%=request.getContextPath()%>/doctor/doctor/doctors">在职医生资料</a></li>
                    </ul>      
                  </div>
                </div>
              </div>
           </div>        
        </div>
        <!--后台遍历内容--><!-- 父级高度100%，左右高度都100%，右边overflow:auto;可调左右一致 -->
        <div class="col-xs-10"  style="height: 100%;overflow:auto;">
	        <div class="page-header" style="color:#1cb394; ">
	                    <h3><sitemesh:write property='title' /></h3>
	        </div>
            <sitemesh:write property='body' />
        </div>
        
    </div>
    
    
    <footer class="footer">
    <p style="text-align:center;padding-top: 10px; ">电话：020-38256735　18825094492&nbsp; &nbsp;&nbsp; 传真：020-38256735</p>
    <p style="text-align:center;">ICP备案号：粤ICP备26000422号&nbsp; &nbsp;&nbsp; 广东技术师范学院&nbsp; © 2016-2020 www.gpnu.edu.cn, 版权所有</p>
    </footer>
  </body>
</html>
