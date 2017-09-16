package nguyenvt.controllers.update;

import nguyenvt.daos.AccountDAO;
import nguyenvt.dto.AccountDTO;
import nguyenvt.stuff.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateAccountController extends HttpServlet {
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String name = request.getParameter("txtName");
            String email = request.getParameter("txtMail");
            int id = Integer.parseInt(request.getParameter("txtAccountId"));
            int roleId = Integer.parseInt(request.getParameter("txtRoleId"));
            if (confirm.equals(password)){
                AccountDTO accountDTO = new AccountDTO(id, username, password, name, email, roleId);
                AccountDAO accountDAO = new AccountDAO();
                boolean result = accountDAO.updateAccount(accountDTO);
                if (result) {
                    url = Url.HOME_PAGE;
                    HttpSession session = request.getSession();
                    session.setAttribute("ACCOUNT", accountDTO);
                }
            } else {
                url = Url.UPDATE_ACCOUNT_PAGE;
                request.setAttribute("ERROR", "Password not match");
            }
        } catch (Exception e) {
            log("Error at UpdateAccountController: " + e.getMessage());
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
