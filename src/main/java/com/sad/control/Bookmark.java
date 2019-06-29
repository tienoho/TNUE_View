package com.sad.control;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.SimpleBookmark;
import com.sad.model.BookmarkCls;
import com.sad.utils.Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "Bookmark", urlPatterns = "/bookmark")
public class Bookmark extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String url = new Report().getUrl(id);
        PrintWriter out = response.getWriter();
        try {
            new BookmarkCls(url, response,request).inPdf();
        } catch (NullPointerException | com.itextpdf.text.exceptions.InvalidPdfException e) {
            out.println("Table of content not available");
        }
    }

    private void inspectPdf(String filename, HttpServletResponse response) {
        try {
            PdfReader reader = new PdfReader(filename);
            List<HashMap<String, Object>> bookmarks = SimpleBookmark.getBookmark(reader);
            for (HashMap<String, Object> bookmark : bookmarks) {
                showTitle(bookmark, response);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showTitle(HashMap<String, Object> bm, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            String pageNo = (String) bm.get("Page");
            int pageNumber = Integer.parseInt(pageNo.split("\\s")[0]);
            String title = (String) bm.get("Title");
            out.println("<a onclick=\"bookJump(" + pageNumber + ")\">" + title + "</a>");
            out.println("<br>");
            List<HashMap<String, Object>> kids = (List<HashMap<String, Object>>) bm.get("Kids");
            if (kids != null) {
                for (HashMap<String, Object> kid : kids) {
                    showTitle(kid, response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
