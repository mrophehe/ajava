package javaprogram;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class StudentDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public StudentDetailsServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");

        // Get student details from the request
        String name = request.getParameter("name");
        String usn = request.getParameter("usn");
        String marksParam = request.getParameter("totalMarks");
        
        int totalMarks = 0;
        try {
            totalMarks = Integer.parseInt(marksParam);
        } catch (NumberFormatException e) {
            totalMarks = -1; // You can also show an error message if you want
        }

        // Generate student details message
        String detailsMessage = "Student Name: " + name + "<br>"
                + "USN: " + usn + "<br>"
                + "Total Marks: " + (totalMarks >= 0 ? totalMarks : "Invalid Input");

        // Write student details message to the response
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Student Details</h1>");
        response.getWriter().println("<p>" + detailsMessage + "</p>");
        response.getWriter().println("</body></html>");
    }
}
