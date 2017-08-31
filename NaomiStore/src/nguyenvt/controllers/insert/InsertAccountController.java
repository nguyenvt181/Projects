package nguyenvt.controllers.insert;

import nguyenvt.daos.AccountDAO;
import nguyenvt.dtos.AccountDTO;
import nguyenvt.utilities.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertAccountController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String name = request.getParameter("txtName");
            String mail = request.getParameter("txtMail");
            if (!confirm.equals(password)){
                url = Url.REGISTER_PAGE;
                request.setAttribute("RESULT", "Confirm not match");
            } else {
                AccountDAO accountDAO = new AccountDAO();
                AccountDTO accountDTO = new AccountDTO(username, password, name, mail, 2);
                boolean result = accountDAO.insertAccount(accountDTO);
                if (result){
                    url = Url.LOGIN_PAGE;
                } else {
                    url = Url.REGISTER_PAGE;
                    request.setAttribute("RESULT", "Register failed");
                }
            }
        } catch (Exception e){
            log("Error at InsertAccountController: " + e.getMessage());
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
