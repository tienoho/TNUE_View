<%@ page import="com.sad.model.CheckIp" %>
<%@ page import="com.sad.model.CheckPermission" %>
<%@ page import="com.sad.utils.Report" %>
<%@ page import="java.util.Objects" %>
<%@ page import="com.sad.model.Access" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${sessionScope[param['id']].title}</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:useBean id="access" class="com.sad.utils._Access" scope="session"/>
<%--Lấy thông tin truy cập--%> <%-- bỏ dòng này khi không cần kiểm tra truy cập--%>
<jsp:useBean id="report" class="com.sad.utils.Report" scope="request"/>
<%--Lấy thông tin báo cáo--%>
<%
    String id = request.getParameter("id");
    String jid = request.getSession().getId();
    String url = new Report().getUrl(id);
    String ips = Access.ip();

    // Lấy ip và kiểm tra ip có phù hợp
    String ipAddress = request.getHeader("X-FORWARDED-FOR");
    if (ipAddress == null) {
        ipAddress = request.getRemoteAddr();
    } else {
        response.sendRedirect("error.jsp?code=1");
    }

    boolean bIp = new CheckIp().checkIp(ipAddress, ips);
    new Report().updateIp(id, ipAddress);

    // Lấy loại người dùng và phân quyền người dùng
    String borStatus = new Report().getBorStatus(id);
    boolean bBorStatus = new CheckPermission(borStatus, id).checkPermission();
    boolean b = new Report().checkLog(id, jid);
    boolean viewForIp = Access.view();

    if (!b) {
        response.sendRedirect("error.jsp?code=7");
        return;
    }
    // kiểm tra có trong nhóm đặc biệt hay ko
//    if (borStatus.equals("10")) {
//        response.sendRedirect("error.jsp?code=11");
//        return;
//    }
    // Nếu ko có trong nhóm đặc biệt và ko thuộc ip được phân quyền
    // Sang trang báo lỗi, có hiện thị ip mạng của người dùng
    if (!bBorStatus) {
        if (!viewForIp) {
            if (!bIp) {
                response.sendRedirect("error.jsp?code=6");
                session.setAttribute("code", ipAddress);
                return;
            }
        }
    }
%>
<div class="navbar navbar-default navbar-fixed-top">
</div>
<div style="height: 65px"></div>
<div class="col-md-4 col-md-offset-3">
    <div>
        <dl class="dl-horizontal">
            <dt>Title
            </dt>
            <dd>${sessionScope[param['id']].title}</dd>
            <%--Lấy tên tài liệu từ session--%>
            <dt>Author</dt>
            <dd>${sessionScope[param['id']].author}</dd>
            <%--Lấy tên tác giả từ session--%>
            <dt>Imprint</dt>
            <dd>${sessionScope[param['id']].imprint}</dd>
            <%--Lấy tên nhà xuất bản từ session--%>
            <dt>Year</dt>
            <dd>${sessionScope[param['id']].year}</dd>
            <%--Lấy năm xuất bản từ session--%>
            <dt></dt>
            <dd>
                <%if (url.toLowerCase().endsWith(".pdf")) {%>
                <c:choose> <%--1--%>
                    <c:when test="${access.read(param['id']) == true}"> <%--2--%>
                        <a href="view.jsp?id=${param['id']}" class="btn btn-primary"
                           onclick="${report.updateRead(param['id'])}">View</a>
                    </c:when> <%--3--%>
                </c:choose><%--4--%>
                <%}%> <%--Bỏ 1,2,3,4 để sử dụng tài liệu không cần cấp quyền--%>
                <% if (bBorStatus) {%>
                <a href="download?id=${param['id']}" class="btn btn-warning"
                   onclick="${report.updateDownload(param['id'])}">Download</a>
                <%} else {%>
                <c:choose> <%--1--%>
                    <c:when test="${access.download(param['id']) == true}"> <%--2--%>
                        <a href="download?id=${param['id']}" class="btn btn-warning"
                           onclick="${report.updateDownload(param['id'])}"> Download</a>
                    </c:when> <%--3--%>
                </c:choose> <%--4--%> <%--Bỏ 1,2,3,4 để sử dụng tài liệu không cần cấp quyền--%>
                <%}%>
            </dd>
        </dl>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>