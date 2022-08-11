package fr.eni.rockpaperscissors;

import java.io.*;
import java.util.Objects;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "RpsServlet", value = "/rps-servlet")
public class RpsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String playerChoice = request.getParameter("player");
        String computerChoice;

        Random random = new Random();
        int randomNumber = random.nextInt(3 + 1);

        switch (randomNumber) {
            case 1:
                computerChoice = "rock";
                break;
            case 2:
                computerChoice = "paper";
                break;
            default:
                computerChoice = "scissors";
                break;
        }

        if (Objects.equals(playerChoice, computerChoice)) {
            request.setAttribute("result", "Tie !");
        } else if ((Objects.equals(playerChoice, "rock") && Objects.equals(computerChoice, "scissors"))
                || (Objects.equals(playerChoice, "paper") && Objects.equals(computerChoice, "rock"))
                || (Objects.equals(playerChoice, "scissors") && Objects.equals(computerChoice, "paper"))) {
            request.setAttribute("result", "You win !");
        } else {
            request.setAttribute("result", "You lose !");
        }

        request.setAttribute("player", playerChoice);
        request.setAttribute("computer", computerChoice);

        RequestDispatcher rd = request.getRequestDispatcher("/java/rockPaperScissors/src/main/webapp/WEB-INF/outcome.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/java/rockPaperScissors/src/main/webapp/WEB-INF/index.jsp");
    }

    public void destroy() {
    }
}