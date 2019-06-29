package com.sad.model;

import com.sad.utils.KetNoi;
import com.sad.utils.marc21.Marc;
import com.sad.utils.marc21.MarcBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Info {

    private static String bib, data;
    private static MarcBean marcBean;



    public static void load(String bib) {
        Info.bib = bib;
        Z00Data();
        marcBean();
    }

    private static void Z00Data() {
        try {
            Connection connection = KetNoi.ORACLE();
            String sql = "SELECT Z00_DATA FROM LSP01.Z00 WHERE LSP01.Z00.Z00_DOC_NUMBER = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bib);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                data = resultSet.getString(1);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void marcBean() {
        marcBean = Marc.marcBeans(bib, data);
    }

    public static String title() {
        return marcBean.getTi245();
    }

    public static String author() {
        return marcBean.getAu245();
    }

    public static String imprint() {
        return marcBean.getIm260();
    }

    public static String year() {
        return marcBean.getYe260();
    }
}
