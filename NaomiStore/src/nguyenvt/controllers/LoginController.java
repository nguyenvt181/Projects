package nguyenvt.controllers;

import nguyenvt.daos.AccountDAO;
import nguyenvt.daos.ProductDAO;
import nguyenvt.dtos.AccountDTO;
import nguyenvt.utilities.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            AccountDAO accountDAO = new AccountDAO();
            AccountDTO accountDTO = accountDAO.checkLogin(username, password);
            if (accountDAO == null){
                request.setAttribute("ERROR", "Oops! Something went wrong!");
            } else {
                url = Url.HOME_PAGE;
                HttpSession session = request.getSession();
                ProductDAO productDAO =  new ProductDAO();
                session.setAttribute("ACCOUNT", accountDTO);
                session.setAttribute("PRODUCT", productDAO.getList());
            }
        } catch (Exception e) {
            log("Error at LoginController: " + e.getMessage());
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
