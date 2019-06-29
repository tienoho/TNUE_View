package com.sad.model;

import com.sad.utils.KetNoi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Print {

    private static String  rec_key, note3;
    private static int error;

   /* public static void main(String[] args) {
        load("000043345000001");
        System.out.println(getNote3());
    }*/
    public static void load(String rec_key) {
        Print.rec_key = rec_key;
        Z403Data(Print.rec_key);
    }

    private static void Z403Data(String rec_key) {
        try {
            Connection connection = KetNoi.ORACLE();
            String sql = "SELECT Z403_NOTE_3 FROM LSP01.Z403 WHERE LSP01.Z403.Z403_REC_KEY LIKE '%" + rec_key + "%'";
            PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setString(1, rec_key);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                note3 = resultSet.getString(1);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getNote3() {
        return note3;
    }
    public static int getError() {
        return error;
    }

    public static void doPrint(InputStream in, String fileName, int pageNumberStart, int pageNumberEnd) throws IOException {
        try {
            new SplitPDF().splitPDF(
                    in,
                    new FileOutputStream(fileName + "_copy.pdf"),
                    pageNumberStart, pageNumberEnd);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        in.close();
    }
}