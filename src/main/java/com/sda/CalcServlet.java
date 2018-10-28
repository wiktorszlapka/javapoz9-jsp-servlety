package com.sda;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //optional umożliwiają obsługę nulli
        Integer a = mapToInteger(req.getParameter("a"));
        Integer b = mapToInteger(req.getParameter("b"));


        System.out.println();
        System.out.println();
        System.out.println(req.getContextPath());
        System.out.println(req.getPathInfo());
        System.out.println(req.getServletPath());
        System.out.println();
        System.out.println();
        System.out.println();


        CalculationResult result = calculate(req.getPathInfo(), a,b);

        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Wynik " + result.resultRepresentation + "</h1>");
    }

    private CalculationResult calculate(String path, int a, int b) {
        if (path.endsWith("add")) {
            return new CalculationResult(a + b,
                    a + " + " + b + " = " + (a + b));
        } else if (path.endsWith("substract")) {
            return new CalculationResult(a - b, a + " - " + b + " = " + (a - b));
        } else if (path.endsWith("multiply")) {
            return new CalculationResult(a * b, a + " * " + b + " = " + (a * b));
        } else {
            return new CalculationResult(0, "Unsupported operation");
        }
    }

    private static class CalculationResult {
        private Integer result;
        private String resultRepresentation;

        public CalculationResult(Integer result, String resultRepresentation) {
            this.result = result;
            this.resultRepresentation = resultRepresentation;
        }

    }

    private Integer mapToInteger (String param) {
        return Optional.ofNullable(param)
                .filter(e -> StringUtils.isNumeric(e))
                .map(e -> Integer.valueOf(e))
                .orElse(0);
    }




}
