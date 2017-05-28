package com.sqlcmd;

import java.sql.Connection;

public class App {

    public static void main(String[] args) throws Exception {

        // todo enter database name, username, password
        // todo connect
        // todo list of tables
        // todo all other commands: help, add...



//        IOUtils.println("Please enter database name, username and password");
//        IOUtils.println("Use the pattern: dbname|username|password");
//
////        String userInput = IOUtils.inputString();
//        String userInput = "sqlcmd|postgres|postgres";
//        String[] parts = userInput.split("\\|");
//        if (parts.length < 2) {
//            IOUtils.println("Incorrect input. Please, try again.");
//        }

        String dataBase = "sqlcmd";
        String user = "postgres";
        String password = "postgres";

        DabaBaseManager dbManager = new DabaBaseManager();
        dbManager.connect(dataBase, user, password);
        Connection connection = dbManager.getConnection();
//                    parts[0], parts[1], parts[2]);

        // tables
        String[] tables = dbManager.getNamesOfTables();
        for (int i = 0; i < tables.length; i++) {
            System.out.println();
        }

//        connection.close();
//        Statement statement;
//        ResultSet rs;
//
//        // insert
////        Statement statement = connection.createStatement();
////        statement.executeUpdate("INSERT INTO users (name, password)" +
////                "VALUES ('11','22')");
//
//        // select
//        statement = connection.createStatement();
//        rs = statement.executeQuery("SELECT * FROM users");//WHERE columnfoo = 500
//        System.out.println("----");
//        while (rs.next()) {
//            System.out.print("id: " + rs.getString(1));
//            System.out.print(" | name: " + rs.getString(2));
//            System.out.println(" | pass: " + rs.getString(3));
//            System.out.println("----");
//        }
//        rs.close();
//        statement.close();
//
//        // delete
//        statement = connection.createStatement();
//        statement.executeUpdate("DELETE FROM users " +
//                "WHERE id >= 6");
//        statement.close();
//
//        // update
//        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users " +
//                "SET password = ?" +
//                "WHERE id = 5");
//        preparedStatement.setString(1, "555");
//        preparedStatement.executeUpdate();
//        preparedStatement.close();
//
//
//        connection.close();
    }



//    private static Connection getConnection(String dataBase, String user, String password) throws SQLException {
//        return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/" +
//                dataBase, user, password);
//    }
}
