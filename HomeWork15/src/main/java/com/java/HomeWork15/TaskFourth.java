package com.java.HomeWork15;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task4_7")
public class TaskFourth extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("No data POST");
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String middleName = req.getParameter("middlename");
        String email = req.getParameter("email");
        String telNumber = req.getParameter("phone");
        int age = Integer.parseInt(req.getParameter("age"));
        boolean mailing = req.getParameter("mailing") != null;
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<h1>Ваши переданные анкетные данные</h1>");
        printWriter.write("<p><b>Фамилия: </b>" + surname + "</p>");
        printWriter.write("<p><b>Имя: </b>" + name + "</p>");
        printWriter.write("<p><b>Отчество: </b>" + middleName + "</p>");
        printWriter.write("<p><b>Номер телефона: </b>" + telNumber + "</p>");
        printWriter.write("<p><b>Эл. почта: </b>" + email + "</p>");
        printWriter.write("<p><b>Возраст: </b>" + age + "</p>");
        printWriter.write("<p><b>Подписка на рассылку: </b>" + ((mailing) ? "Да" : "Нет") + "</p>");
        printWriter.print("<div><a href='javascript:history.back();'>Назад</a></div>");
        printWriter.close();
    }
}
