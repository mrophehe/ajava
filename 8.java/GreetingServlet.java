package javaprogram;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class GreetingServlet extends HttpServlet {
    
    public GreetingServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");

        // Get username parameter from the request
        String username = request.getParameter("username");

        // Generate greeting message
        String greetingMessage = "Hello " + (username != null && !username.isEmpty() ? username : "User") + ", How Are You?";

        // Write greeting message to the response
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>" + greetingMessage + "</h1>");
        response.getWriter().println("</body></html>");
    }
}
