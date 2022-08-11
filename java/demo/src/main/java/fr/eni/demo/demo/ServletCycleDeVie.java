package fr.eni.demo.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/modules/module2/ServletCycleDeVie")
public class ServletCycleDeVie extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int nbInit = 0;
    private int nbServlet = 0;
    private int nbDestroy = 0;

    public void init() throws ServletException {
        this.nbInit++;
        super.init();
    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.nbServlet++;
        response.getWriter().append("Nb appels Servlet: ").append(String.valueOf(this.nbServlet));
        response.getWriter().append(System.lineSeparator());
        response.getWriter().append("Nb Init: ").append(String.valueOf(this.nbInit));
        response.getWriter().append(System.lineSeparator());
        response.getWriter().append("Nb destroy: ").append(String.valueOf(this.nbDestroy));

    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void destroy() {
        this.nbDestroy++;
        super.destroy();
    }
}
