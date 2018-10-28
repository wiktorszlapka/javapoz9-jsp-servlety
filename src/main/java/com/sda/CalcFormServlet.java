package com.sda;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class CalcFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter(); //zwracamy formluarz umożliwiający wpisanie wartości

        writer.println("<div>");
        Optional<String> errorMessage = Optional.ofNullable(req.getParameter("error_message"));
        if (errorMessage.isPresent()) {
            writer.println("<h1 style=\"color: red;\">" + errorMessage.get() + "</h1>");
        }

        writer.println("<form method=\"GET\" action=\"calc\">"); //po submisji będzie wysyłał get-a
        writer.println("<input type=\"number\" name=\"a\" label=\"number\" />");

        writer.println("<select name=\"operation\">");
        writer.println("    <option value='add'>+</option>"); //wizualnie będzie + ale wyślemy add
        writer.println("    <option value='substract'>-</option>");
        writer.println("    <option value='multiply'>*</option>");
        writer.println("</select>");
        writer.println("<input type=\"number\" name=\"b\" label=\"number\" />");
        writer.println("<input type=\"submit\" value=\"Submit\" />");
        writer.println("</form>");
        writer.println("</div>");
    }
}
