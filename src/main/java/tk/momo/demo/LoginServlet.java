package tk.momo.demo;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password1 = request.getParameter("password");

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

            List<String> users = new ArrayList<>();
            List<String> password = new ArrayList<>();
            while(rs.next()){
                users.add(rs.getString(1));
                password.add(rs.getString(2));
            }

            for (int i = 0; i < users.size(); i++) {
                response.getWriter().println(users.get(i)+" "+password.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
