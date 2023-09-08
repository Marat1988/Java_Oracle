package com.java.HomeWork15;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task2")
public class TaskTwo extends HttpServlet {
    private final int maxNumber = 10;
    private final int minNumber = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        try (PrintWriter printWriter = resp.getWriter()) {
            int number = Integer.parseInt(req.getParameter("number"));
            printWriter.write("<h1>Вы отправили число: " + number + "</h1>");
            printWriter.write("<p>Таблица умножения</p>");
            if (number >= minNumber && number <= maxNumber) {
                for (int i = minNumber; i <= maxNumber; i++) {
                    printWriter.write("<p>" + number + " * " + i + " = " + number * i + "</p>");
                }
            } else {
                printWriter.write("Переданное число должно быть от 1 до 10");
            }
            printWriter.print("<a href='javascript:history.back();'>Назад</a>");
        } catch (Exception e) {
            resp.getWriter().write("<p>" + e.getMessage() + "</p>");
        }
    }
}
