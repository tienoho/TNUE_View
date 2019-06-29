package com.sad.control;

import com.sad.utils.Report;
import com.sad.utils._Access;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DownloadControl", urlPatterns = "/download")
public class DownloadControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();

        String url = new Report().getUrl(id);

        boolean download = new _Access().download(id);

        if (download) {
            out.println("<a href='" + url + "'>click here to download</a>");
            new Report().updateDownload(id);
        }else {
            response.sendRedirect("error?code=3");
        }
    }
}
