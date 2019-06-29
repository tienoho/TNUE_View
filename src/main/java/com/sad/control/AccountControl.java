package com.sad.control;

import com.sad.model.Access;
import com.sad.model.Account;
import com.sad.utils.Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccountControl", urlPatterns = "/account")
public class AccountControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        // lấy tên người dùng
        String username = request.getRemoteUser();
//         lay du lieu bib, sq
        String bib = new Report().getBib(id);
        String sq = new Report().getSq(id);
//         qua account lay ra UserId,bortype,borstatus
        Account.load(username);
        String userID = Account.userId();
        String borType = Account.borType();
        String borStatus = Account.borStatus();
//         quyen su dung tai lieu
        Access.load(borStatus, bib, sq);
        /*boolean r = Access.read();
        boolean d = Access.download();*/
        boolean r = true;
        boolean d = false;
//         update ban ghi
        new Report().updateAccount(id, userID, borType, borStatus, r, d);
        response.sendRedirect("info?id=" + id + "");
    }
}
