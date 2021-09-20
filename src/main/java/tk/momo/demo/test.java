package tk.momo.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;
        Connection con;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/users";
            String user = "root";
            String pw = "password";
            con = DriverManager.getConnection(url, user, pw);
            String sql = "select * from users";
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }

        List<String> username = new ArrayList<>();
        List<String> password = new ArrayList<>();
        while(rs.next()){
            username.add(rs.getString(1));
            password.add(rs.getString(2));
        }
        System.out.print(username.get(1));
        System.out.print(password.get(1));
    }
}
