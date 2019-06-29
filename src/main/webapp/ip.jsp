<%--<%@ page import="java.util.ArrayList" %>--%>
<%--<%@ page import="com.sad.model.CheckIp" %>--%>
<%--<%@ page import="com.sad.utils.Report" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<fmt:setBundle basename="face_vi"/>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<title>TDTU Library</title>--%>
    <%--<!-- Bootstrap -->--%>
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->--%>
    <%--<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script src="js/html5shiv.min.js"></script>--%>
    <%--<script src="js/respond.min.js"></script>--%>
    <%--<![endif]-->--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:useBean id="access" class="com.sad.utils._Access" scope="session"/>--%>
<%--&lt;%&ndash;Lấy thông tin truy cập&ndash;%&gt; &lt;%&ndash; bỏ dòng này khi không cần kiểm tra truy cập&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;%>--%>
    <%--&lt;%&ndash;String id = request.getParameter("id");&ndash;%&gt;--%>
    <%--&lt;%&ndash;String jid = request.getSession().getId();&ndash;%&gt;--%>
    <%--&lt;%&ndash;boolean b = new Report().checkLog(id, jid);&ndash;%&gt;--%>

    <%--&lt;%&ndash;if (!b) {&ndash;%&gt;--%>
        <%--&lt;%&ndash;response.sendRedirect("error.jsp?code=7");&ndash;%&gt;--%>
        <%--&lt;%&ndash;return;&ndash;%&gt;--%>
    <%--&lt;%&ndash;}&ndash;%&gt;--%>

    <%--&lt;%&ndash;ArrayList<String> listIp = new CheckIp().getListIp();%>&ndash;%&gt;--%>
<%--<form method="post" style="padding-left: 31px;line-height: 1.8" action="IPControl" enctype="multipart/form-data">--%>
    <%--Chọn tập tin chứa địa chỉ IP: <input type="file" class="btn-primary" name="dataFile" id="fileChooser"/>--%>
    <%--<input type="submit" class="btn-primary" value="Upload"/>--%>
    <%--<a href="ipaddress.txt" download="ipaddress.txt">Download</a>--%>
<%--</form>--%>
<%--<div style="width: 500px; align-content: center">--%>
    <%--<div class="container-fluid">--%>
        <%--<div class="col-md-12">--%>
            <%--<div class="table-responsive">--%>
                <%--<table class="table table-bordered">--%>
                    <%--<tr class="bg-primary text-center">--%>
                        <%--<td>Tên địa chỉ IP</td>--%>
                    <%--</tr>--%>
                    <%--<% for (String aListIp : listIp) {%>--%>
                    <%--<tr>--%>
                        <%--<td><%=aListIp%>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <%--<%}%>--%>
                <%--</table>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
