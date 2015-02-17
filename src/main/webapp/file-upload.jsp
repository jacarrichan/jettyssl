<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test-file-upload</title>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript">
	function callback() {
		$.ajax({
			type : "post",
			url : "FileUploadStatus",//响应文件上传进度的servlet
			success : function(msg) {
				document.getElementById("span").innerHTML = "已上传：" + msg;//显示读取百分比
				document.getElementById("table").width = msg;//通过表格宽度 实现进度条
			}
		});
	}
	function formSubmit() {
		window.setInterval("callback()", 100);//每隔100毫秒执行callback
		document.form.submit();
	}
</script>
</head>
<body>
	<form action="FileUploadServlet" method="post"
		enctype="multipart/form-data" target="_parent" name="form">
		<input type="file" name="file"><input type="button"
			onclick="formSubmit()" value="提交">
	</form>

	<span id="span"></span>
	<table width="300px;" border="0">
		<tr>
			<td>
				<table id="table" height="20px;" style="background-color: gray;">
					<tr>
						<td></td>
					</tr>
				</table>//用来实现进度条显示
			</td>
		</tr>
	</table>
</body>
</html>
