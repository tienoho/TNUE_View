package com.sad.model;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.SimpleBookmark;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class BookmarkCls {
    private PrintWriter out;
    private HttpServletResponse response;
    private HttpServletRequest request;
    private String url;
    private int total;
    private int pageNumber;

    public BookmarkCls(String url, HttpServletResponse response, HttpServletRequest request) throws IOException {
        this.url = url;
        this.response = response;
        this.out = this.response.getWriter();
        this.request = request;
    }

    public void inPdf() throws IOException {
        PdfReader reader = new PdfReader(url);
        java.util.List<HashMap<String, Object>> bookmarks = SimpleBookmark.getBookmark(reader);
        for (HashMap<String, Object> bookmark : bookmarks) {
            showTitle(bookmark, this.response);
        }
        reader.close();
    }

    private void showTitle(HashMap<String, Object> bm, HttpServletResponse response) throws IOException {
        String pageNo = (String) bm.get("Page");
        pageNumber = Integer.parseInt(pageNo.split("\\s")[0]);
        String title = (String) bm.get("Title");
        String id = request.getParameter("id");
        out.println("<a onclick=\"bookJump(" + id + "" + pageNumber + ")\">" + title + "</a>");
        out.println("<br>");
        java.util.List<HashMap<String, Object>> kids = (java.util.List<HashMap<String, Object>>) bm.get("Kids");
        if (kids != null) {
            for (HashMap<String, Object> kid : kids) {
                showTitle(kid, this.response);
            }
        }
    }
}
