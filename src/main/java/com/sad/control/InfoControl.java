package com.sad.control;

import com.sad.model.Info;
import com.sad.utils.InfoBean;
import com.sad.utils.Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InfoControl", urlPatterns = "/info")
public class InfoControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String bib = new Report().getBib(id);
        HttpSession session = request.getSession();
        // lay ra title,author,imprint,year
        Info.load(bib);
        String title = Info.title();
        String author = Info.author();
        String imprint = Info.imprint();
        String year = Info.year();
        InfoBean ib = new InfoBean(title, author, imprint, year);

        session.setAttribute(id, ib);
        // ghep trang hien thi vao controller
        response.sendRedirect("info.jsp?id=" + id + "");
    }
}
