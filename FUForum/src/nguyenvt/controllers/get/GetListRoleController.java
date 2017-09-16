package nguyenvt.controllers.get;

import nguyenvt.daos.RoleDAO;
import nguyenvt.dto.RoleDTO;
import nguyenvt.stuff.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetListRoleController extends HttpServlet {
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            RoleDAO roleDAO = new RoleDAO();
            request.setAttribute("ROLE_LIST", roleDAO.getListRole());
            url = Url.MANAGE_ROLE_PAGE;
        } catch (Exception e) {
            log("Error at GetListRoleController: " + e.getMessage());
            request.setAttribute("ERROR", "Something went wrong!");
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
