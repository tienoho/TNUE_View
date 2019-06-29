<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TNUE Library - External Link</title>
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <link href="css/exlibris.css" rel="stylesheet">
    <script type="text/javascript"
            src="http://gc.kis.v2.scr.kaspersky-labs.com/1B603D4A-9627-3C44-B31B-5AB154BCBBCA/main.js"
            charset="UTF-8"></script>
</head>
<body>
<%
    int code = Integer.parseInt(request.getParameter("code"));
    String str = "";
    String str1 = "";
    switch (code) {
        case 1:
            str = "Url Not Found";
            break;
        case 2:
            str = "You Can't Read This File";
            break;
        case 3:
            break;
        case 4:
            str = "File Not Found";
            break;
        case 5:
            str = "Username Or Password wrong";
            break;
        case 6:
            str = "Object is not permitted for your IP address (" + session.getAttribute("code") + ")";
            str1 = "No Permission to View File - You are not permitted to view this file due to the following reason(s):";
            break;
        case 7:
            str = "Object available only for Signed In users. Please Sign In.";
            str1 = "No Permission to View File - You are not permitted to view this file due to the following reason(s):";
            break;
        case 8:
            str1 = "Cập nhật địa chỉ IP thành công !";
            break;
        case 9:
            str1 = "File này dường như ko phải là một file text (\".txt\") !";
            break;
        case 10:
            str1 = "Không có file được chọn !";
            break;
        case 11:
            str1 = "Bạn không có quyền truy cập file số này !";
            break;
    }
%>
<table width=100% border=0 cellspacing=5>
    <tr>
        <td class=td1>
            <p align="center"><em><b><%=str1%>
            </b></em></p>
            <%=str%><br><br>
        </td>
    </tr>
    <tr>
    </tr>
</table>

<!-- filename: copyrights -->
<br>
<p class="copyright">
    Copyright © 2017 Inspire library - Ton Duc Thang University
</p>
</body>
</html>
