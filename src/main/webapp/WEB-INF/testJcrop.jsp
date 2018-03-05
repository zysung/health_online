<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jcrop Test</title>
<script type="text/javascript"  src="<%=request.getContextPath() %>/resources/dist/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/dist/jquery.Jcrop.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/dist/jquery.Jcrop.css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/dist/bootstrap.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/dist/bootstrap.css"> 
<script type="text/javascript">
      //定义一个全局api，这样操作起来比较灵活
        var api = null;
        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.readAsDataURL(input.files[0]);
                reader.onload = function (e) {
                    $('#cutimg').removeAttr('src');
                    $('#cutimg').attr('src', e.target.result);
                    api = $.Jcrop('#cutimg', {
                        setSelect: [ 20, 20, 200, 200 ],
                        aspectRatio: 1,
                        onSelect: updateCoords,
                        boxWidth:600,
                        boxHeight:600
                    });
                };
                if (api != undefined) {
                    api.destroy();
                }
            }
            function updateCoords(obj) {
                $("#x").val(obj.x);
                $("#y").val(obj.y);
                $("#w").val(obj.w);
                $("#h").val(obj.h);
            };
            
        }
    </script>
    
</head>
<body>
<form name="form" action="<%=request.getContextPath()%>/UploadDemo/uploadHeadImage" class="form-horizontal"
      method="post" enctype="multipart/form-data">
    <div class="modal-body text-center">
        <div class="zxx_main_con">
            <div class="zxx_test_list">
                <input class="photo-file" type="file" name="imgFile" id="fcupload" onchange="readURL(this);"/>
                <img alt="" src="" id="cutimg" class="img-responsive"  style="max-width:none;"/>
                <input type="hidden" id="x" name="x"/>
                <input type="hidden" id="y" name="y"/>
                <input type="hidden" id="w" name="w"/>
                <input type="hidden" id="h" name="h"/>
            </div>
        </div>
    </div>
	
    <div class="modal-footer">
        <button id="submit" onclick="">上传</button>
    </div>
</form>


</body>
</html>