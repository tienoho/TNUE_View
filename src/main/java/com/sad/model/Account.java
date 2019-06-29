package com.sad.model;

import com.sad.utils.KetNoi;

import java.sql.*;
import java.util.ArrayList;

public class Account {

    private static String user, barcode;

    public static void load(String username) {
        user = "00" + username.toUpperCase();
        barcode = "01" + username.toUpperCase();
    }

    private static String checkIn(String type) {
        String out = null;
        try {
            Connection connection = KetNoi.ORACLE();
            String sql = "SELECT Z308_ID FROM LSP00.Z308 WHERE LSP00.Z308.Z308_REC_KEY = '"+type+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                out = resultSet.getString(1);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }

    public static String userId() {
        String chkUser = checkIn(user);
        String chkBarcode = checkIn(barcode);
        String out = null;
        if (chkUser != null) {
            out = chkUser.trim();
        }
        if (chkBarcode != null) {
            out = chkBarcode.trim();
        }
        return out;
    }

    private static String setZ305(String userid){
        StringBuilder sb = new StringBuilder();
        sb.insert(0, "                 ");
        sb.replace(0, userid.length(), userid);
        sb.replace(12, 17, "TNUE ");
        return sb.toString();
    }

    private static ArrayList<String> borInfo(){
        String user = setZ305(userId());
        ArrayList<String> a = new ArrayList<>();
        try {
            Connection connection = KetNoi.ORACLE();
            String sql = "SELECT Z305_BOR_STATUS,Z305_BOR_TYPE FROM LSP50.Z305 WHERE Z305_REC_KEY = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                a.add(resultSet.getString(1));
                a.add(resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    public static String borType(){
        return borInfo().get(1);
    }

    public static String borStatus(){
        return borInfo().get(0);
    }
}
