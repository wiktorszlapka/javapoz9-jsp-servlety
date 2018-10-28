package com.sda;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet { //rozszerza klasę httpservlet
//alt+insert -> ctrl + o

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String nameToDisplay = StringUtils.isEmpty(name) ? "Annonymus" : name;

        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Hello" + nameToDisplay + "</h1>");
    }
}
