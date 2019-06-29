package com.sad.model;

import java.io.*;
import java.util.ArrayList;

public class ExportIP {

    public ExportIP(String path) throws IOException {
        exportData(getListIP(path));
    }

    private ArrayList<String> getListIP(String path) throws IOException {
        ArrayList<String> listIP = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
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

    private void exportData(ArrayList<String> listIP) {
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File f = new File(CheckIp.PATH);
            FileWriter fw = new FileWriter(f);
            fw.write("");
            //Bước 2: Ghi dữ liệu
            for (int i = 0; i < listIP.size(); i++) {
                fw.write(listIP.get(i) + "\n");
            }
            //Bước 3: Đóng luồng
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
