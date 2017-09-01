package nguyenvt.controllers;

import nguyenvt.utilities.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            String action = request.getParameter("btnControl");
            if (action.equals("Login")) {
                url = Url.LOGIN_CONTROLLER;
            } else if (action.equals("Logout")) {
                url = Url.LOGOUT_CONTROLLER;
            } else if (action.equals("Insert Account")) {
                url = Url.INSERT_ACCOUNT_CONTROLLER;
            } else if (action.equals("Update Account")) {
                url = Url.UPDATE_ACCOUNT_CONTROLLER;
            } else if (action.equals("Insert Product")) {
                url = Url.INSERT_PRODUCT_CONTROLLER;
            } else if (action.equals("Search Product")) {
                url = Url.SEARCH_PRODUCT_CONTROLLER;
            } else if (action.equals("Update Product")) {
                url = Url.UPDATE_PRODUCT_CONTROLLER;
            } else if (action.equals("Remove Product")) {
                url = Url.REMOVE_PRODUCT_CONTROLLER;
            } else if (action.equals("Insert Cart")) {
                url = Url.INSERT_CART_CONTROLLER;
            } else if (action.equals("Update Cart")) {
                url = Url.UPDATE_CART_CONTROLLER;
            } else if (action.equals("Remove Cart")) {
                url = Url.REMOVE_CART_CONTROLLER;
            } else if (action.equals("Insert Order")) {
                url = Url.INSERT_ORDER_CONTROLLER;
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
