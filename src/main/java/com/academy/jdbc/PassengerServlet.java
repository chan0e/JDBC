package com.academy.jdbc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PassengerServlet", value = "/PassengerServlet")
public class PassengerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBcodes passenger = new DBcodes();
        List<Passenger> passengerList  = passenger.getdata();

        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<table border=\"1\"><tr><th>PassengerName</th><th>Grade</th><th>Age</th></tr>");
        for (Passenger str: passengerList) {
            out.println("<tr>");
            out.println("<td><p><a href=\"flight.jsp?id="+ str.getPassengerNo()+"\">" + str.getPassengerName() + "</a></p></td>");
            out.println("<td><p>" + str.getGrade() + "</p></td>");
            out.println("<td><p>" + str.getAge() + "</p></td>");
            out.println("</tr>");
        }
        out.println("</table>");

        out.println("</html></body>");

    }


}
