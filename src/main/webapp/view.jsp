<%@ page import="com.sad.model.Content" %>
<%@ page import="com.sad.utils.Report" %>
<%@ page import="javax.xml.bind.DatatypeConverter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Viewer</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/include.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            //Initial load of page
            $(document).ready(sizeContent);
            //Every resize of window
            $(window).resize(sizeContent);

            //Dynamically assign height
            function sizeContent() {
                var newWith = window.innerWidth
                    || document.documentElement.clientWidth
                    || document.body.clientWidth;
                var newHeight = window.innerHeight
                    || document.documentElement.clientHeight
                    || document.body.clientHeight;
                $(".full_image").css("width", newWith + "px");
                // language=JQuery-CSS
            }
        });
    </script>


    <script type="text/javascript">
        // Zoom in zoom out
        jQuery(document).ready(function () {
            var images = jQuery('.navbar'); //caches the query when dom is ready
            var CELL_WIDTH = 100;
            var ASPECT = 1.5;
            jQuery("#slider").slider({
                step: 1,
                min: 40,
                max: 250,
                value: 100,
                slide: function (event, ui) {
                    var size = (CELL_WIDTH * ui.value / 100) + "%";
                    // images.stop(true).animate({width: "100%", height: "50px"});
                    document.body.style.zoom = size;
                    images.css("width", "100%").css("height", "50px");
                }
            });
        });
    </script>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link href="css/ui.css" rel="stylesheet" type="text/css"/>
    <%--<style>--%>
        <%--@media print {--%>
            <%--html, body {--%>
                <%--display: none !important; /* hide whole page */--%>
            <%--}--%>
        <%--}--%>
    <%--</style>--%>
</head>
<%
    String id = request.getParameter("id"); // lấy id tài liệu
    String url = new Report().getUrl(id); // lấy đường dẫn từ log
    Content content = new Content(url); // tạo
    content.loadPDF();
    int total = content.getTotal();
    String jid = request.getSession().getId();
    boolean b = new Report().checkLog(id, jid);
    if (!b) {
        response.sendRedirect("error.jsp?code=7");
        return;
    }
%>

<body onkeydown="return false">
<jsp:useBean id="access" class="com.sad.utils._Access" scope="session"/>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="">TNUE</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a data-toggle="modal" data-target="#myModal">Table Of Contents</a></li>
                <c:choose>
                    <c:when test="${access.download(param['id']) == true}">
                        <li><a href="download?id=${param['id']}">Download</a></li>
                    </c:when>
                </c:choose>
                <%--<li><a href="print?id=${param['id']}">Print</a></li>--%>
            </ul>
            <form class="navbar-form navbar-right">
                <span class="glyphicon glyphicon-glass">Go to: </span>
                <div class="form-group">
                    <select onchange="goTo()" id="page" title="choose page" class="form-control">
                        <%for (int i = 0; i < total; i++) {%>
                        <option value="${param['id']}<%=i+1%>">Page <%=i + 1%>
                        </option>
                        <%}%>
                    </select>
                </div>
            </form>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
    <div id="slider"></div>
</nav>

<%--bookmark--%>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Table of contents</h4>
            </div>
            <div class="modal-body">
                <jsp:include page="bookmark?id=${param['id']}"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<%--bookmark--%>

<div style="margin-top:65px">
</div>
<div class="container-fluid">
    <%
        for (int i = 0; i < total; i++) {
            String image = DatatypeConverter.printBase64Binary(content.image(i, total));
    %>
    <div class="thumb-wrapper">
        <img id="${param['id']}<%=i+1%>" style="margin:0 auto" class="full_image"
             src="data:image/jpg;base64,<%=image%>">
        <br><br>
    </div>
    <%
        }
        content.closeDocument();
    %>

</div>
</body>
</html>
