package com.sad.model;

import com.sad.utils.Report;

public class Input {

    private static String aUrl, aUri;
    private static final String HOST = "http://catalog.dhsptn.edu.vn";
    //private static final String MY_HOST = "https://databases.tdtu.edu.vn:8443";
    //private static final String MY_HOST = "https://ilink.dhsptn.edu.vn";
    private static final String MY_HOST = "https://viewpdf.herokuapp.com";
    // private static final String HOST = "http://aleph.ted.com.vn:8991";
    private static final String HTTP = "http://";
    private static final String HTTPS = "https://";

    public static void load(String aUrl, String aUri) {
        Input.aUrl = aUrl;
        Input.aUri = aUri;
    }

    public static String url() {
        if (aUrl.startsWith(HTTP) || aUrl.startsWith(HTTPS) || aUrl.startsWith(MY_HOST)) {
            return aUrl;
        } else {
            return HOST + aUrl;
        }
    }

    public static String sequence() {
        int i = aUri.indexOf("sequence=");
        return aUri.substring(i + 9, i + 15);
//        int i = aUri.indexOf("line_number=");
//        return aUri.substring(i + 12, i + 16);
    }

    public static String bib() {
        int i;
        if (aUri.contains("doc_number=")) {
            i = aUri.indexOf("doc_number=");
            return aUri.substring(i + 11, i + 20);
        } else if (aUri.contains("doc5%number=")) {
            i = aUri.indexOf("doc5%number=");
            return aUri.substring(i + 12, i + 21);
        } else {
            return null;
        }
    }
}
