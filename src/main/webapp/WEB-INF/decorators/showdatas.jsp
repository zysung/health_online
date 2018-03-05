<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title><sitemesh:write default="健康数据展示"/></title>
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
		font-size: 62.5%;
		font-family:'Microsoft Yahei','Simsun';		
	}
	.navbar{
    background-color: #4c4c4c;
		font-size:14px;
		margin:0;
		border-radius:0;
    border: 0;
	}
	#left_nav{
		height:550px;
		padding:0;
		border-right:1px solid #1c4c77;
	}
	.panel-body{
		padding:0;
	}
	.panel{
		border-radius:0;
		border-right:0;
		padding-left:10px;
	}	
	.panel-body ul li{
		height:30px;
		line-height:30px;
		font-size:14px;
		width:100%;
		overflow:hidden;
	}
	.panel:hover{

		background:#1c4c77;
		color:white;
	}
	#content{
		margin-top: 20px;
    	padding-right: 200px;
	}
	.footer{
		padding-top:5px;
		position:relative;
		top:0;
		height:150px;
		background:#4c4c4c;
		color:#ffffff;
    font-size:14px; 
	}
  .footer a{
    color: white;
    margin-left: 20px;
    margin-right: 20px;
    text-decoration:none;list-style:none; 
  }
</style>


  </head>
  
  <body>
    <!--<div style="background:#1cb394; width:100%; height:5px;"></div>-->
	<nav class="navbar navbar-inverse" role="navigation" >
		<div class="navbar-header" style="margin-left: 10%;">
		  <a href="http://192.168.0.100:8080/health"> 
		  <img src="<%=request.getContextPath() %>/staticfile/JKZYimages/logo_t_u16.png" width="130px" height="50px" >
  			</a>
  	</div>    
        <div class="collapse navbar-collapse" style="margin-right: 10%;">	   	
        	<ul class="nav navbar-nav navbar-right">
      			<li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">健康数据统计<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">健康数据统计</a></li>
              </ul>
            </li>
          </ul>
        </div>
  </nav>
  <div style="border: 0; margin: 0;padding: 0;">
     <img src="<%=request.getContextPath() %>/staticfile/JKZYimages/pic_u2.jpg" width="100%">
  </div>



 	<div class="row">
    	<div class="col-xs-2 col-md-offset-1" id="left_nav">
			<div class="panel-group" id="accordion" style="margin-top:5px;">
              <div class="panel panel-default" style="border-radius:0; border-left: 5px solid #1c4c77;		margin-top:20px;">
                <div class="panel-heading" >
                  <h4 class="panel-title">
                    <a href="<%=request.getContextPath()%>/showdatas/latestsportdatas" >运动数据统计</a>
                  </h4>
                </div>
              </div> 
              <div class="panel panel-default" style="border-radius:0; border-left: 5px solid #1c4c77;">
                <div class="panel-heading" >
                  <h4 class="panel-title">
                    <a href="<%=request.getContextPath()%>/showdatas/latestcustodydatas">监护数据统计</a>
                  </h4>
                </div>
              </div>     
            </div>      
        </div>
        <!--后台遍历内容-->
        <div class="col-xs-9"  id="content">
          	<p style="color:#1c4c77; font-size:16px;margin-bottom:10px;"><sitemesh:write property='title' /></p>
            <sitemesh:write property='body' />
        </div>
        
    </div>
    
    
    <footer class="footer">
    
    <p style="text-align:center; border-bottom: 1px solid #797979; height:40px; vertical-align:middle; padding-top: 8px; ">
        <a href="#">关于我们</a>
        <a href="#">联系我们</a>
        <a href="#">医生推荐</a>
        <a href="#">友情链接</a>
        <a href="#">药品查询</a>
        <a href="#">合作服务</a>
        <a href="#">许可协议</a>
        <a href="#">加入收藏</a>
        <a href="#">设为首页</a>
        <a href="<%=request.getContextPath()%>/admin">管理登录</a>
    </p>

    <p style="text-align:center;padding-top: 10px; ">电话：020-38256735　18825094492&nbsp; &nbsp;&nbsp; 传真：020-38256735</p>
    <p style="text-align:center;">ICP备案号：粤ICP备26000422号&nbsp; &nbsp;&nbsp; 广东技术师范学院&nbsp; © 2016-2020 www.gpnu.edu.cn, 版权所有</p>
    </footer>
  </body>
</html>
