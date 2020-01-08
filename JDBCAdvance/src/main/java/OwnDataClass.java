// Step 1: import relate libs

import java.sql.*;

public class OwnDataClass {
    static final String DBURL = "jdbc:mysql://localhost:3306/emp";
    static final String USER = "root";
    static final String PWD = "123456r";

    public static void main(String[] args) {
        // Step 2 get connection driver
        try {
            Connection com = DriverManager.getConnection(DBURL, USER, PWD);
            Statement stm = com.createStatement();
            String sql = "SELECT * FROM employees";
            ResultSet rs = stm.executeQuery(sql);
            int count = 0;
            while (rs.next()) {
                count = rs.getRow();
            }
                System.out.println("Total rows: " + count);
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }
}
