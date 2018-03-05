<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>医生信息修改</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/staticfile/css/modelsty.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/staticfile/css/bootstrapValidator.css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/staticfile/js/bootstrapValidator.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/staticfile/js/zh_CN.js"></script>
  	<script type="text/javascript" src="<%=request.getContextPath()%>/staticfile/js/cropbox.js"></script>
  	<script type="text/javascript">
		$(window).load(function() {
			/*图片裁剪控制*/
			var options =
			{
				thumbBox: '.thumbBox',
				spinner: '.spinner',
			};
			var cropper = $('.imageBox').cropbox(options);
			$('#uploadFile').on('change', function(){
				var reader = new FileReader();
				reader.onload = function(e) {
					options.imgSrc = e.target.result;
					cropper = $('.imageBox').cropbox(options);
				};
				reader.readAsDataURL(this.files[0]);
				this.files = [];
			});
			$('#btnCrop').on('click',function(){
				var img = cropper.getDataURL();
				$('#cropped').html('');
				$('#cropped').append('<img src="'+img+'" align="absmiddle" style="width:64px;margin-top:4px;border-radius:2px;box-shadow:0px 0px 12px #7E7E7E;" ><p>64px*64px</p>');
				$('#cropped').append('<img src="'+img+'" align="absmiddle" style="width:128px;margin-top:4px;border-radius:2px;box-shadow:0px 0px 12px #7E7E7E;"><p>128px*128px</p>');
				$('#cropped').append('<img src="'+img+'" align="absmiddle" style="width:180px;margin-top:4px;border-radius:2px;box-shadow:0px 0px 12px #7E7E7E;"><p>180px*180px</p>');
			});
			$('#btnZoomIn').on('click', function(){
				cropper.zoomIn();
			});
			$('#btnZoomOut').on('click', function(){
				cropper.zoomOut();
			});
			$('#smbtn').on('click',function(){
				var img = cropper.getDataURL();
				if(img != null){
					$('#imgRtn img').attr('width',150);
					$('#imgRtn img').attr('height',150);
					$('#imgRtn img').attr('src',img);
					$('#uploadImg').attr("value",img);
					$('#ulbtn').text("更改图片");
					alert($('#uploadImg').attr('value'));
				}
			});
			
			/*bootstrapValidator进行前端验证*/
			$('form').bootstrapValidator({
	        message: 'This value is not valid',
	        feedbackIcons: {
	                valid: 'glyphicon glyphicon-ok',
	                invalid: 'glyphicon glyphicon-remove',
	                validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	               	name: {
	                    message: '医生名验证失败',
	                    validators: {
	                        notEmpty: {
	                            message: '医生名不能为空'
	                        }
	                    }			
	                },
				   marks: {
		                validators: {
		                    notEmpty: {
		                        message: '医院评分不能为空'
				            }
				       	}
				    },
	                practicePoint:{
	                	validators:{
	                		notEmpty:{
	                			message: '医院地址不能为空'
	                		}
	                	}
	                },
	                phone:{
	                	validators:{
	                		notEmpty:{
	                			message:'至少留一个联系电话',
	                		},
	                		regexp: {
	                            regexp: /^[0-9]+$/,
	                            message: '电话号码只能包含数字'
	                        }
	                	}
	              },
	          /* 	uploadFile: {
	                validators: {
		                    file: {
		                        extension: 'jpg,png',
		                        type: 'image/jpeg,image/png', 
		                        maxSize: 1*1024*1024,  
		                        message: '请选择jpg或png格式图片，且图片大小须小于5M'
		                    }
		          }
		       }*/
	            }
	        });
	        $('#resetBtn').click(function() {
        		$('form').data('bootstrapValidator').resetForm(true);
    		});
			
		});
	</script>

  </head>
  
  <body>
  <!-- 设置modelAttribute属性：会自动把表单中的值添加到user.xxx中，相当于user做modelDriver -->
  <!-- 若此时没写action属性，会提交到同一个url中的method值设置为POST的controller方法中
  			（即method=RequestMethod.POST的方法里） -->
<div class="container">
  		<div class="row">
        <div class="col-lg-8">
		  <sf:form method="post"   modelAttribute="doctor"  class="form-horizontal"  enctype="multipart/form-data">
		  			<div class="form-group">
                        <label class="col-lg-3 control-label">医生头像：</label>
                        <div class="col-lg-5">
                        	<!-- 如果name写logo的话会自动匹配hospital的logo属性，因为写了modelAttribute，所以name写别的字段
                        	只当一个普通值传给controller,到那再set 
                            <input type="file"  class="form-control"  name="imgfile"  id="imgfile"  />
                        	<img  class="img-rounded " name="preimg"  id="preimg" src=""  alt="预览图片"  /> -->
                        	
                        	<!-- 模态框文件上传 -->
							<div id="imgRtn" class="col-lg-8">
							<c:choose>
							  <c:when test="${doctor.avatar ne null }"><img id=“previewImg” src="avatar"  height="150" width="150" style="box-shadow:0px 0px 12px #7E7E7E;"/></c:when>
							 <c:otherwise><img id="previewImg" src=""/></c:otherwise>
							</c:choose>
							</div>
							<div class="col-lg-4">
							<button class="btn btn-primary " data-toggle="modal" data-target="#myModal" id="ulbtn" >更改图片</button>
							</div>
							<!-- 模态框（Modal） -->
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							    <div class="modal-dialog" style="width: 650px;">
							        <div class="modal-content">
							            <div class="modal-header">
							                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							                <h4 class="modal-title" id="myModalLabel">图片上传 </h4>
							            </div>
							            <div class="modal-body">
							
										  <div class="imageBox">
											<div class="thumbBox"></div>
											<div class="spinner" style="display: none">请上传图片</div>
										  </div>
										  <div class="action"> 
											<div class="new-contentarea"> 
											<!-- 上传图片按钮框设计 -->
											<input type="file" class=""  name="uploadFile" id="uploadFile"  style="display: none;"/>
											<div class="input-group" >  
											    <input id="photoCover" class="form-control"  type="text" >  
											    <span class="input-group-btn">
												    <button class="btn btn-primary" type="button" onclick="$('input[id=uploadFile]').click();">浏览</button>
												</span>
											    
											</div>  			   
											<script type="text/javascript">  
												$('input[id=uploadFile]').change(function() {  
													$('#photoCover').val($(this).val());  
												});  
											</script>  
											</div>
											
											<input type="button" id="btnCrop"  class="btn-primary btn" value="预览" style="float:right;"/>
											<input type="button" id="btnZoomIn" class="btn-primary btn" value="+"  style="float:right;margin-right: 5px;width:10%;"/>
											<input type="button" id="btnZoomOut" class="btn-primary btn" value="-" style="float:right;margin-right: 5px;width:10%;"/>
											<!-- 真正传到后台的base64编码，需后台将base64码解码成二进制图像文件 -->
											<input type="hidden" id="uploadImg" name="uploadImg"/>
										  </div>
										  <div id="cropped"></div>
							
							            </div>
							            <div class="modal-footer">
							                <button type="button" class="btn btn-primary" data-dismiss="modal" id="smbtn">提交更改</button>
							            </div>
							        </div><!-- /.modal-content -->
							    </div><!-- /.modal -->
							</div>
                        	
                        	
                        	
                        </div> 
                    </div>
		  			<div class="form-group" >
		                <label class="col-lg-3 control-label">医生名：</label>
		                <div class="col-lg-5">
		                	<sf:input path="name" class="form-control"  />
		                </div>
		            </div>
			  		<div class="form-group" >
			                <label class="col-lg-3 control-label">性别：</label>
			                <div class="col-lg-5">
			                	<sf:select path="sex" class="form-control" >
			                		<option value="">--选择一个性别--</option>
						  			<sf:option value="男">男</sf:option>
						  			<sf:option value="女">女</sf:option>
						  		</sf:select>
			                </div>
			        </div>
			  		<div class="form-group" >
		                <label class="col-lg-3 control-label">所属科室：</label>
		                <div class="col-lg-5">
		                	<sf:input path="expertise" class="form-control" />
		                </div>
		            </div>	
			  		  <div class="form-group" >
			                <label class="col-lg-3 control-label">职称：</label>
			                <div class="col-lg-5">
			                	<sf:select path="title" class="form-control" >
			                		<option value="">-- 选择一个职称--</option>
						  			<sf:option value="主任医师">主任医师</sf:option>
						  			<sf:option value="副主任医师">副主任医师</sf:option>
						  			<sf:option value="主治医师">主治医师</sf:option>
						  			<sf:option value="住院医师">住院医师</sf:option>
						  		</sf:select>
			                </div>
			        </div>
		            <div class="form-group" >
			                <label class="col-lg-3 control-label">医生评分：</label>
			                <div class="col-lg-5">
			                	<sf:select path="marks" class="form-control" >
			                		<option value="">-- 选择一个评分--</option>
						  			<sf:option value="非常满意">非常满意</sf:option>
						  			<sf:option value="满意">满意</sf:option>
						  			<sf:option value="一般">一般</sf:option>
						  			<sf:option value="不满意">不满意</sf:option>
						  			<sf:option value="其他">其他</sf:option>
						  		</sf:select>
			                </div>
			        </div>
			        <div class="form-group" >
		                <label class="col-lg-3 control-label">所属医院：</label>
		                <div class="col-lg-5">
		                	<sf:input path="practicePoint" class="form-control"  />
		                </div>
		            </div>	
		             <div class="form-group" >
		                <label class="col-lg-3 control-label">联系电话：</label>
		                <div class="col-lg-9" style="padding:0;">         	
		                	<div class="col-md-4" ><sf:input path="phone" class="form-control" /></div>
		                </div>
		            </div>	
		            <div class="form-group" >
		                <label class="col-lg-3 control-label">医生简介：</label>
		                <div class="col-lg-5">
		                	<sf:textarea path="description" class="form-control" />
		                </div>
		            </div>	
		           
			  		<div class="form-group">
                            <div class="col-lg-9 col-lg-offset-3">
	                             <input type="submit" class="btn btn-primary" value="更改医生信息">
	                            <button type="button" class="btn btn-danger" id="resetBtn">重设</button>
                            </div>
                     </div>
		  </sf:form>	
		  </div>
		  </div>
		</div>
  </body>
</html>
