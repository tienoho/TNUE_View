package com.sad.control;

import com.sad.model.Info;
import com.sad.model.Input;
import com.sad.model.Print;
import com.sad.utils.InfoBean;
import com.sad.utils.Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PrintControl", urlPatterns = "/print")
public class PrintControl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*PrintWriter out = response.getWriter();
        out.println("In Construct");
*/
        String id = request.getParameter("id");
        String bib = new Report().getBib(id);
        //HttpSession session = request.getSession();
        //set Rec_key vao
        Print.load(bib + "" + Input.sequence());
        // lay ra title,author,imprint,year
        Info.load(bib);
        String title = Info.title();
        String author = Info.author();
        String imprint = Info.imprint();
        String year = Info.year();
        InfoBean ib = new InfoBean(title, author, imprint, year);

        /*out.println(Print.getNote3());*/

        //session.setAttribute(id, ib);
        // ghep trang in vao controller
        response.sendRedirect("print.jsp?id=" + id + "");
    }
}
