package com.java.HomeWork15;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task1")
public class TaskOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<p>Any fool can write code that a computer can understand.\n" +
                "Good programmers write code that humans can\n" +
                "understand.</p>");
        printWriter.print("<a href='javascript:history.back();'>Назад</a>");
        printWriter.close();
    }
}
