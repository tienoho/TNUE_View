package com.sad.utils;

import com.sad.model.Input;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Report {

    public boolean checkExist(String jid, String bib, String sq) {
        boolean b = false;
        try {
            Connection connection = KetNoi.HYPER();
            String sql = "SELECT * FROM BAOCAO.VIEW WHERE JID = ? AND SYSTEM_BIB = ? AND BIB_SEQUENCE = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, jid);
            statement.setString(2, bib);
            statement.setString(3, sq);
            ResultSet resultSet = statement.executeQuery();
            b = resultSet.next();
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    public void create(String jid, String bib, String sequence, String url) {
        try {
            Connection connection = KetNoi.HYPER();
//            String sql = "INSERT INTO BAOCAO.VIEW(JID, SYSTEM_BIB, BIB_SEQUENCE, FILE_URL) VALUES (?,?,?,?)";
            String sql = "INSERT INTO BAOCAO.VIEW(JID, SYSTEM_BIB, BIB_SEQUENCE, FILE_URL,FILE_READ,CAN_READ) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, jid);
            statement.setString(2, bib);
            statement.setString(3, sequence);
            statement.setString(4, url);
            statement.setBoolean(5, true);
            statement.setBoolean(6, true);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String RID(String jid, String bib, String sequence, String url) {
        String id = null;
        try {
            Connection connection = KetNoi.HYPER();
            String sql = "SELECT ID FROM BAOCAO.VIEW WHERE JID = ? AND SYSTEM_BIB = ? AND BIB_SEQUENCE = ? AND FILE_URL = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, jid);
            statement.setString(2, bib);
            statement.setString(3, sequence);
            statement.setString(4, url);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getString(1);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private String getString(String id, String column) {
        String out = null;
        try {
            Connection connection = KetNoi.HYPER();
            String sql = "SELECT " + column + " FROM BAOCAO.VIEW WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
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

    private boolean getBoolean(String id, String column) {
        boolean out = false;
        try {
            Connection connection = KetNoi.HYPER();
            String sql = "SELECT " + column + " FROM BAOCAO.VIEW WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                out = resultSet.getBoolean(1);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }

    public String getBib(String id) {
        return getString(id, "SYSTEM_BIB");
    }

    public String getUrl(String id) {
        return getString(id, "FILE_URL");
    }

    public String getBorStatus(String id) {
        return getString(id, "BORSTATUS");
    }

    public String getSq(String id) {
        return getString(id, "BIB_SEQUENCE");
    }

    public void updateAccount(String id, String userId, String borType, String borStatus, boolean r, boolean d) {
        try {
            Connection connection = KetNoi.HYPER();
            String sql = "UPDATE BAOCAO.VIEW SET USERID = ?,BORTYPE = ?,BORSTATUS =?,CAN_READ=?,CAN_DOWNLOAD=? WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            statement.setString(2, borType);
            statement.setString(3, borStatus);
            statement.setBoolean(4, r);
            statement.setBoolean(5, d);
            statement.setString(6, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateUse(String id, String column) {
        try {
            Connection connection = KetNoi.HYPER();
            String sql = "UPDATE BAOCAO.VIEW SET " + column + " = 'true' WHERE ID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRead(String id) {
        updateUse(id, "FILE_READ");
    }

    public void updateDownload(String id) {
        updateUse(id, "FILE_DOWNLOAD");
    }

    public boolean read(String id) {
        return getBoolean(id, "CAN_READ");
    }

    public boolean download(String id) {
        return getBoolean(id, "CAN_DOWNLOAD");
    }

    public void updateDownloadID(String id) {
        updateUse(id, "CAN_DOWNLOAD");
    }

    public boolean checkLog(String id, String jid) {
        boolean b = false;
        try {
            Connection connection = KetNoi.HYPER();
            String sql = "SELECT * FROM BAOCAO.VIEW WHERE ID = ? AND JID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, jid);
            ResultSet resultSet = statement.executeQuery();
            b = resultSet.next();
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            b = false;
        }
        return b;
    }

    public void updateIp(String id, String ip) {
        try {
            Connection connection = KetNoi.HYPER();
            String sql = "UPDATE BAOCAO.VIEW SET IP_NET_ADDRESS=? WHERE ID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ip);
            statement.setString(2, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
