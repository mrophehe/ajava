package javaprogram;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/SetCookie")
public class SetCookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create and configure cookie
        Cookie cookie = new Cookie("EMPID", "AN2356");
        cookie.setMaxAge(3600); // 1 hour
        cookie.setPath("/");

        // Add cookie to response
        response.addCookie(cookie);

        response.setContentType("text/html");
        response.getWriter().println("<h3>Cookie 'EMPID' with value 'AN2356' has been set.</h3>");
    }
}
