package com.java.HomeWork15;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task3")
public class TaskThree extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        int number = Integer.parseInt(req.getParameter("number"));
        printWriter.write("<h1>Вы отправили число: " + number + "</h1>");
        printWriter.write("<button id=\"startGame\">Начать игру</button>");
        printWriter.write("<script>" +
                "document.getElementById('startGame').addEventListener('click', " +
                "function(event)" +
                "{" +
                "let low = 0;" +
                "let high = 100;" +
                "var guess = Math.floor((low + high)/2);" +
                "let response = \"\";" +
                "let attempts = 0;" +
                "while (response != 'да'){\n" +
                "guess = Math.floor((low + high)/2)  \n" +
                "response = prompt(\"Мое число равно \" + guess + \". Оно больше, меньше или равно введенному Вами числу: \\n Введите: да, больше, или меньше\");\n" +
                "attempts++;\n" +
                "if (response == 'больше'){\n" +
                "low = guess;\n" +
                "\n" +
                "} else if (response == 'меньше'){\n" +
                "high = guess;\n" +
                "\n" +
                "}else if( response == 'да'){\n" +
                "alert(\"Компьютер угадал загаданное число \" + guess + \". Количество попыток: \" + attempts + \"\");\n" +
                "}else{\n" +
                "alert(\"Пожалуйста, вводите только да, больше, или меньше\")\n" +
                "}\n" +
                "\n" +
                "}" +
                "});" +
                "</script>");
        printWriter.print("<div><a href='javascript:history.back();'>Назад</a></div>");
        printWriter.close();
    }
}
