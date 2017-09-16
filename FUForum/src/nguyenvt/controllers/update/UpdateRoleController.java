package nguyenvt.controllers.update;

import nguyenvt.daos.RoleDAO;
import nguyenvt.dto.RoleDTO;
import nguyenvt.stuff.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateRoleController extends HttpServlet {
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            int id = Integer.parseInt(request.getParameter("txtRoleId"));
            String name = request.getParameter("txtName");
            RoleDTO roleDTO = new RoleDTO(id, name);
            RoleDAO roleDAO = new RoleDAO();
            boolean result = roleDAO.updateRole(roleDTO);
            if (result) {
                url = Url.MANAGE_ROLE_PAGE;
                request.setAttribute("ROLE_LIST", roleDAO.getListRole());
            }
        } catch (Exception e) {
            log("Error at UpdateRoleController: " + e.getMessage());
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
