package com.sad.model;

import com.sad.utils.Type;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class SaveFile {//tạo ra tên ngẫu nhiên
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static Random rnd = new Random();
    String fileName;

    public String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public InputStream inputStream(String url) throws IOException {
        return new URL(url).openStream();
    }

    //thay địa chỉ đến tomcat
    public String getFileName() {
        /*return "/exlibris/apache-tomcat-8.5.23/webapps/ebook/pdf/" + fileName;*/
        return Type.linkPdf + fileName;
    }

    public String getName() {
        return fileName;
    }
}