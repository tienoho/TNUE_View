package com.sad.control;

import com.sad.model.Input;
import com.sad.utils.Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "FileControl", urlPatterns = "/file")
public class FileControl extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // kiem tra dau vao co ton tai hay ko neu ko ton tai chuyen sang trang bao loi
        try {
            String aUrl = request.getParameter("alephUrl");
            String aUri = request.getParameter("alephUri");
            // jid
            String jid = request.getSession().getId();
            // dua ra bib,sq,url
            Input.load(aUrl, aUri);
            String bib = Input.bib();
            String sq = Input.sequence();
            String url = Input.url();
            // kiem tra trong csdl jid,system bib da ton tai chua
            if (!new Report().checkExist(jid, bib, sq)) {
                // luu vao bang du lieu
                new Report().create(jid, bib, sq, url);
            }
            // lay ra id
            String id = new Report().RID(jid, bib, sq, url);
            // đến trang kiểm tra tài khoản
           response.sendRedirect("account?id=" + id + ""); // nếu muốn bỏ qua không kiểm tra tài khoản đánh dấu dòng này
             //response.sendRedirect("info?id="+id+""); // mở dòng này khi muốn bỏ qua check tài khoản
        } catch (NullPointerException e) {
            response.sendRedirect("error?code=1");
        }
    }
}
