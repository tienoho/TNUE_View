<%@ page import="com.sad.model.DeleteFile" %>
<%@ page import="com.sad.utils.Type" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/01/2018
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap -->
    <script type="text/javascript">
        var Browser1 = navigator.userAgent;
        function printPDF(htmlPage) {
            var w = window.open(htmlPage);
            //w.print();
        }
    </script>
</head>
<body>
<center>
    <h2>Duyệt tốt nhất khi sử dụng trình duyệt Chrome,cốc cốc </h2>
    <br/>
    <iframe src="/ebook/pdf/${param['id']}_copy.pdf" id="PDFtoPrint" hidden="hidden"></iframe>
    <div id="contentBrown">
        <input type="button" value="InChrome"
               onclick="document.getElementById('PDFtoPrint').focus(); document.getElementById('PDFtoPrint').contentWindow.print();">
    </div>
    <table>
        <tr>
            <td>
                <div id="contentFireFox">
                    <input type="submit" value="PrintFireFox"
                           name="Submit" id="printbtn"
                           onclick="printPDF('/ebook/pdf/${param['id']}_copy.pdf')"/>
                    <br/>
                    <h2>Hướng đẫn in khi dùng trình duyệt FireFox</h2>
                    <br/>
                    <img src="../resources/hdPrint.png">
                </div>
            </td>
        </tr>
    </table>
</center>

<script type="text/javascript">
    if (Browser1.indexOf('Firefox') >= 0) {
        //showFireFox();
        document.getElementById("contentBrown").style.display = 'none';
        document.getElementById("contentFireFox").style.display = 'block';

    } else {
        document.getElementById("contentBrown").style.display = 'block';
        document.getElementById("contentFireFox").style.display = 'none';
        //hideFireFox();
    }
</script>
<%
/*    new DeleteFile("/exlibris/apache-tomcat-8.5.23/webapps/ebook/pdf/",request.getParameter("id")+"_copy.pdf");*/
    new DeleteFile(Type.linkPdf,request.getParameter("id")+"_copy.pdf");
%>
</body>
</html>
