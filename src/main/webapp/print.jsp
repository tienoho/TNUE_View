<%@ page import="com.sad.utils.Report" %>
<%@ page import="com.sad.model.Content" %>
<%@ page import="java.net.InetAddress" %>
<%@ page import="com.sad.model.Print" %>
<%@ page import="com.sad.utils.Type" %>
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
    <%--check số trang cần in --%>
    <script type="text/javascript">
        // JavaScript Document

        function validateForm() {
            var startNumber = document.forms["myInput"]["txtStart"].value;
            var endNumber = document.forms["myInput"]["txtEnd"].value;
            var kiemTraStart = isNaN(startNumber);
            var kiemTraEnd = isNaN(endNumber);
            var total = parseInt(document.forms["myInput"]["getTotal"].value);
            var totalPrint = parseInt(document.forms["myInput"]["getNote3"].value);
            if ((startNumber == "") || (startNumber <= 0) || (endNumber == "") || (endNumber <= 0)) {
                alert("Số trang in không được để trống và phải lớn hơn 0");
                return false;
            }
            if (parseInt(startNumber) > parseInt(endNumber)) {
                alert("Số trang bắt đầu không được lớn hớn số trang kết thúc");
                return false;
            }

            if (parseInt(endNumber) < parseInt(startNumber)) {
                alert("Số trang kết thúc không được bé hớn số trang bắt đầu");
                return false;
            }
            if ((kiemTraStart == true) && (kiemTraEnd == true)) {
                alert("Số trang in phải để ở định dạng số");
                return false;
            }
            if (startNumber > total) {
                alert("Số trang không thể lớn hơn số trang của tài liệu");
                return false;
            } else if (endNumber > total) {
                alert("Số trang không thể lớn hơn số trang của tài liệu");
                return false;
            }
            if ((endNumber - startNumber) + 1 > totalPrint) {
                alert("Tổng số trang in lớn hơn cho phép của tài liệu");
                return false;
            }
        }
    </script>
</head>
<body>
<jsp:useBean id="access" class="com.sad.utils._Access" scope="session"/>
<%--Lấy thông tin truy cập--%> <%-- bỏ dòng này khi không cần kiểm tra truy cập--%>
<jsp:useBean id="report" class="com.sad.utils.Report" scope="request"/>
<%--Lấy thông tin báo cáo--%>
<%
    String id = request.getParameter("id");
    String jid = request.getSession().getId();
    boolean b = new Report().checkLog(id, jid);
    if (!b) {
        response.sendRedirect("error.jsp?code=7");
        return;
    }
    //System.out.println("print.jsp: " + Content.getTotala());
    // System.out.println("getNote3: " + Print.getNote3());
    String ip = request.getHeader("X-Forwarded-For");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("HTTP_CLIENT_IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getRemoteAddr();
    }

    // System.out.println("IP: " + ip);
    //InetAddress addr = InetAddress.getByName(ip);
    //ip TDT: 172.16.68.0
    //ip TED: 192.168.1.0
    int i = ip.lastIndexOf(".");
    String jip = ip.substring(0, i);

%>
<div class="navbar navbar-default navbar-fixed-top">
</div>
<div style="height: 65px"></div>
<div class="col-md-4 col-md-offset-3">
    <div>
        <dl class="dl-horizontal">
            <%
                //Kiểm tra tài liệu có được in hay không
                //=null là không được in
                if (Print.getNote3() != null) {
                    //kiểm tra ip của client có phải ip của thư viện hay không
                    //if (jip.contains("172.16.68")) {
                    if (jip.contains(Type.ipTdt) || jip.contains(Type.ipTed2)) {
            %>
            <dt>Title</dt>
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
            <form action="Printer" method="post" name="myInput" onsubmit="return validateForm()">
                <fieldset>
                    <dt>Số trang tài liệu:</dt>
                    <dd><%=Content.getTotala()%> trang</dd>
                    <dt>Bạn chỉ được in</dt>
                    <dd><%=Print.getNote3()%> trang trong tài liệu</dd>
                    <dt><input type="number" name="id" value="${param['id']}" hidden="hidden"></dt>
                    <dt><input type="number" name="getTotal" hidden="hidden" value="<%=Content.getTotala()%>"></dt>
                    <dt><input type="number" name="getNote3" hidden="hidden" value="<%=Print.getNote3()%>"></dt>
                    <dt>Number Start</dt>
                    <dd><input type="number" name="txtStart" size="40" min="1" max="10000" pattern="[1-9]{2}"/></dd>
                    <dt>Number End</dt>
                    <dd><input type="number" name="txtEnd" size="40" min="1" max="10000" pattern="[1-9]{2}"/></dd>
                    <dt></dt>
                    <dd><input type="submit" value="print"></dd>
                </fieldset>
            </form>

        </dl>
    </div>
</div>
<%
        } else {
            out.print("Bạn không có quyền in ở khu vực này");
        }
    } else
        out.print("Tài này liệu không cho phép in");
%>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>