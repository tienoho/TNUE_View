package com.sad.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ErrorControl", urlPatterns = "/error")
public class ErrorControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int code = Integer.parseInt(request.getParameter("code"));
        String str = "1";
        String str1 = "1";
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
            default:
                break;
        }
        session.setAttribute("str", str);
        session.setAttribute("str1", str1);
        //Danh sách các lỗi xảy ra trong chương trinh
        response.sendRedirect("error.jsp?code=" + code);
    }
}
