package com.sad.model;

import com.sad.utils.KetNoi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Access {

    private static String borStatus, doc, sequence;
    private static String note1, note2, ipAddress;

    public static void load(String borStatus, String doc, String sequence) {
        Access.borStatus = borStatus;
        Access.doc = doc;
        Access.sequence = sequence;
        getInfo();
    }

    private static boolean compare(String db, String borStatus) {
        if (db == null) {
            db = "";
        }
        return db.contains(borStatus);
    }

    private static void getInfo() {
        String q = doc + sequence;
        try {
            Connection connection = KetNoi.ORACLE();
            String sql = "SELECT Z403_NOTE_1,Z403_NOTE_2,Z403_NOTE_5 FROM LSP01.Z403 WHERE Z403_REC_KEY =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, q);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                note1 = resultSet.getString(1);
                note2 = resultSet.getString(2);
                ipAddress = resultSet.getString(3);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String ip() {
        return ipAddress;
    }

    public static boolean read() {
        return !compare(note1, borStatus);
    }

    public static boolean download() {
        return compare(note2, borStatus);
    }

    public static boolean view() {
        return ipAddress == null || Objects.equals(ipAddress, "");
    }
}
