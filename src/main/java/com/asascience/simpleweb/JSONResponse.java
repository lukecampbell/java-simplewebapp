/*
 * Author: Luke Campbell
 */
package com.asascience.simpleweb;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.asascience.models.User;
import java.util.*;

import java.io.IOException;

public class JSONResponse extends HttpServlet {
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        List<User> userList = new ArrayList<User>();
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load sql driver");
        }

        try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/test", "luke",
					"test");
            statement = connection.prepareStatement("SELECT * FROM Users");
            results = statement.executeQuery();
            while(results.next()) {
                User user = new User(results.getInt("id"), results.getString("name"), results.getInt("age"));
                userList.add(user);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("users", userList);
        RequestDispatcher view = request.getRequestDispatcher("json_api.jsp");
        view.forward(request,response);
    }
}


