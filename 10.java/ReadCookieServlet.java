package javaprogram;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/ReadCookie")
public class ReadCookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        String empId = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("EMPID".equals(cookie.getName())) {
                    empId = cookie.getValue();
                    break;
                }
            }
        }

        response.setContentType("text/html");
        if (empId != null) {
            response.getWriter().println("<h3>EMPID Cookie Value: " + empId + "</h3>");
        } else {
            response.getWriter().println("<h3>No cookie found with name EMPID.</h3>");
        }
    }
}
