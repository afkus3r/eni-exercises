package fr.eni.guessTheNumber;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "guessNumberServlet",
        urlPatterns = "/guessNumberServlet",
        initParams =
                {
                        @WebInitParam(description = "Random number's max value", name = "MAX_VALUE", value = "10"),
                        @WebInitParam(description = "Random number's min value", name = "MIN_VALUE", value = "0")
                }
)

public class GuessNumberServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Random random = new Random();
        int randomNumber = random.nextInt(Integer.parseInt(this.getInitParameter("MAX_VALUE")) + 1 - Integer.parseInt(this.getInitParameter("MIN_VALUE"))) + Integer.parseInt(this.getInitParameter("MIN_VALUE"));

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