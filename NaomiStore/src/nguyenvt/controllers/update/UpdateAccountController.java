package nguyenvt.controllers.update;

import nguyenvt.daos.AccountDAO;
import nguyenvt.dtos.AccountDTO;
import nguyenvt.utilities.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateAccountController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            int id = Integer.parseInt(request.getParameter("txtId"));
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String name = request.getParameter("txtName");
            String email = request.getParameter("txtEmail");
            int role = Integer.parseInt(request.getParameter("txtRole"));
            if (!confirm.equals(password)) {
                url = Url.UPDATE_INFORMATION_PAGE;
                request.setAttribute("RESULT", "Confirm not match");
            } else {
                AccountDTO accountDTO = new AccountDTO(id, username, password, name, email, role);
                AccountDAO accountDAO = new AccountDAO();
                boolean result = accountDAO.updateAccount(accountDTO);
                if (result) {
                    url = Url.UPDATE_INFORMATION_PAGE;
                    request.setAttribute("RESULT", "Update Information Successfully");
                } else {
                    url = Url.UPDATE_INFORMATION_PAGE;
                    request.setAttribute("RESULT", "Update Information Failed");
                }
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
