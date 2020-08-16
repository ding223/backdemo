<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <title>权限错误</title>
    <link rel="shortcut icon" href="favicon.ico"> <link href="${cxtPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${cxtPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${cxtPath}/css/animate.css" rel="stylesheet">
    <link href="${cxtPath}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="middle-box text-center animated fadeInDown">
        <h1>403</h1>
        <h3 class="font-bold">权限错误</h3>
        <div class="error-desc">
            您没有此操作权限，请联系管理员
            <br/>您可以返回主页看看
            <br/><a href="" onclick="javascript:parent.location.reload();" class="btn btn-primary m-t">主页</a>
        </div>
    </div>

    <!-- 全局js -->
    <script src="${cxtPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${cxtPath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->
</body>

</html>
