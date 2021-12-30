package ru.owopeef.gamestatistics.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("LoopStatementThatDoesntLoop")
public class MySQLUtil {
    public static String url;
    public static String user;
    public static String password;

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void SQLInit(String host, String db_name, String db_user, String db_password) {
        url = String.format("jdbc:mysql://%s/%s?characterEncoding=latin1&useConfigs=maxPerformance", host, db_name);
        user = db_user;
        password = db_password;
    }

    public static String CheckConnection() {
        try (Connection conn = DriverManager.getConnection(url, user, password)){
            return "§aConnection successful";
        } catch(Exception ex) {
            return "§cConnection failed... §7("+ex.getMessage()+")";
        }
    }

    public static String GetStringFromDB(String query, int columnIndex) {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                return rs.getString(columnIndex);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return null;
    }

    public static List<Integer> GetIntegerListFromDB(String query, int columnIndex) {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            List<Integer> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getInt(columnIndex));
            }
            return list;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return null;
        }
    }

    public static List<String> GetStringListFromDB(String query, int columnIndex) {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            List<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString(columnIndex));
            }
            return list;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return null;
        }
    }
}
