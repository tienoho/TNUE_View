package com.sad.control;

import com.sad.model.Content;
import com.sad.model.SaveFile;
import com.sad.utils.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.sad.model.Print.doPrint;
import static com.sad.model.Print.getError;

//@WebServlet(name = "Printer",urlPatterns = "/printer")
@WebServlet("/Printer")

public class Printer extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String startNumber = request.getParameter("txtStart");
        String endNumber = request.getParameter("txtEnd");

        String name = new SaveFile().randomString(50);
        doPrint(new SaveFile().inputStream(Content.getUrl()), Type.linkPdf + name, Integer.parseInt(startNumber), Integer.parseInt(endNumber));
        if (getError() == 1) {
            response.sendRedirect("error.jsp?code=7");
        } else if (getError() == 2) {
            response.sendRedirect("error.jsp?code=7");
        } else {
            response.sendRedirect("ProccessPrinting.jsp?id=" + name + "");
        }
    }
}
