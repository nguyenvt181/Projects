package nguyenvt.controllers;

import nguyenvt.stuff.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainController extends HttpServlet {
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            String control = request.getParameter("btnControl");
            switch (control) {
                case "Login":
                    url = Url.LOGIN_CONTROLLER;
                    break;
                case "Logout":
                    url = Url.LOGOUT_CONTROLLER;
                    break;
                case "Insert Post":
                    url = Url.INSERT_POST_CONTROLLER;
                    break;
                case "Insert Account":
                    url = Url.INSERT_ACCOUNT_CONTROLLER;
                    break;
                case "Insert Group":
                    url = Url.INSERT_GROUP_CONTROLLER;
                    break;
                case "Accept Post":
                case "Decline Post":
                    url = Url.UPDATE_STATUS_POST_CONTROLLER;
                    break;
                case "Update Account":
                    url = Url.UPDATE_ACCOUNT_CONTROLLER;
                    break;
                case "Update Role":
                    url = Url.UPDATE_ROLE_CONTROLLER;
                    break;
                case "Update Group":
                    url = Url.UPDATE_GROUP_CONTROLLER;
                    break;
                case "Update Post":
                    url = Url.UPDATE_POST_CONTROLLER;
                    break;
                case "Remove Post":
                    url = Url.REMOVE_POST_CONTROLLER;
                    break;
                case "View Own Post":
                    url = Url.GET_LIST_OWN_POST_CONTROLLER;
                    break;
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
