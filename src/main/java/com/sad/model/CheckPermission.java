package com.sad.model;

import com.sad.utils.KetNoi;
import com.sad.utils.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckPermission {
    private String borStatus;
    private String id;

    public CheckPermission(String borStatus, String id) {
        this.borStatus = borStatus;
        this.id = id;
    }

    public boolean checkPermission() {
        boolean b = false;
        List<String> listBorStatus = getListBorStatus();
        for (String aListBorSatus : listBorStatus) {
            if (Objects.equals(borStatus, aListBorSatus)) {
                new Report().updateDownloadID(id);
                b = true;
                break;
            }
        }
        return b;
    }

    private ArrayList<String> getListBorStatus() {
        List<String> list = new ArrayList<>();
        try {
            Connection connection = KetNoi.HYPER();
            String sql = "SELECT * FROM TED.PERMISSION";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) list;
    }

}
