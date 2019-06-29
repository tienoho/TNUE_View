package com.sad.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckIp {

    public static final String PATH = "/exlibris/apache-tomcat-8.5.23/webapps/ebook/ipaddress.txt";

    public boolean checkIp(String ip, String ips) throws IOException {
        return ips == null || Objects.equals(ips, "") || ips.contains(ip) || ips.contains(getIpLocal(ip));
    }


    public ArrayList<String> getListIp() throws IOException {
        ArrayList<String> listIP = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(PATH));
            String textAlign = bufferedReader.readLine();
            listIP.add(textAlign);
            while (textAlign != null) {
                textAlign = bufferedReader.readLine();
                if (textAlign != null) {
                    listIP.add(textAlign);
                }
            }
        } finally {
            bufferedReader.close();
        }
        return listIP;
    }

    // Cắt ip từ dấu chấm từ 2
    private String getIpLocal(String ip) {
        int index = ip.lastIndexOf(".");
        String str = ip.substring(0, ip.lastIndexOf(".", index - 1)) + ".*.*";
        return str;
    }
}
