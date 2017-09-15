package nguyenvt.controllers;

import nguyenvt.stuff.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            String control = request.getParameter("btnControl");
            if (control.equals("Login")){
                url = Url.LOGIN_CONTROLLER;
            } else if (control.equals("Insert Post")) {
                url = Url.INSERT_POST_CONTROLLER;
            } else if (control.equals("Accept Post") || control.equals("Decline Post")) {
                url = Url.UPDATE_STATUS_POST_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.getMessage());
            request.setAttribute("ERROR", "Oops! Something went wrong!");
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }
}
