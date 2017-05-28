package com.sqlcmd;

import java.sql.*;
import java.util.Arrays;

public class DabaBaseManager {

    private Connection connection;

    public static void main(String[] args) {

        String dataBase = "sqlcmd";
        String user = "postgres";
        String password = "postgres";

        DabaBaseManager dbManager = new DabaBaseManager();
        dbManager.connect(dataBase, user, password);

        System.out.println(dbManager.getSizeOfTable("users"));

    }

    public void connect(String database, String user, String password) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Please, add JDBC jar to project.");
            connection = null;
        }

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/" +
                    database, user, password);
        } catch (SQLException e) {
            System.out.println(String.format("Can't get connection for database: %s user: %s password: %s", database, user, password));
            connection = null;


        }
    }

    public Connection getConnection() {
        return connection;
    }

    public String[] getNamesOfTables() {

        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT table_name " +
                    "FROM information_schema.tables " +
                    "WHERE table_schema='public' " +
                    "AND table_type='BASE TABLE'");
        } catch (SQLException e) {
            e.printStackTrace();
            return new String[0];
        }

        String[] tables = new String[100];
        int index = 0;

        try {
            while (rs.next()) {
                tables[index++] = rs.getString("table_name");
            }
            tables = Arrays.copyOf(tables, index, String[].class);
            rs.close();
            statement.close();
            return tables;
        } catch (SQLException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    public int getSizeOfTable(String tableName) {

        int size = 0;

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM " + tableName);
            rs.next();
            size = rs.getInt(1);
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return size;
        }

    }

    public DataSet getData(String tableName) {

        try {
            int size = getSizeOfTable(tableName);

            if (size == 0) {
                return null;
            }

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData rsmd = rs.getMetaData();
            DataSet[] dataSet = new DataSet[size];

            int index = 0;

            while (rs.next()) {
                DataSet entry = new DataSet();

                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    dataSet.put(rsmd.getCatalogName(i), rs.getObject(i));
                }

                dataSet[index++] = entry;
            }

            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }
}