package fr.eni.guessTheNumber;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "guessNumberServlet", value = "/guessNumberServlet")
public class GuessNumberServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Random random = new Random();
        int randomNumber = random.nextInt(10 + 1);

        String number = request.getParameter("number");

        if (Integer.parseInt(number) == randomNumber) {
            response.sendRedirect("http://localhost:8080/Gradle___fr_eni___guessTheNumber_1_0_SNAPSHOT_war/win.html");
        } else {
            response.sendRedirect("http://localhost:8080/Gradle___fr_eni___guessTheNumber_1_0_SNAPSHOT_war/fail.html");
        }
    }

    public void destroy() {
    }
}