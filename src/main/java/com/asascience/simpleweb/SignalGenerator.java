/*
 * Author: Luke Campbell
 */
package com.asascience.simpleweb;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.common.primitives.Doubles;


public class SignalGenerator extends HttpServlet {
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher view = request.getRequestDispatcher("signal.jsp");
        view.forward(request,response);
    }
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        String d = request.getParameter("value");
        double value = Double.parseDouble(d);
        double[] retval = new double[20];
        for(int i=0;i<20;i++) {
            retval[i] = Math.sin(2 * Math.PI * i/10);
        }
        List<Double> values = Doubles.asList(retval);
        request.setAttribute("values", values);
        RequestDispatcher view = request.getRequestDispatcher("signal_result.jsp");
        view.forward(request,response);

    }
}

