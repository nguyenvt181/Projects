package nguyenvt.controllers.insert;

import nguyenvt.daos.GroupDAO;
import nguyenvt.dto.GroupDTO;
import nguyenvt.stuff.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertGroupController extends HttpServlet {
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            String name = request.getParameter("txtName");
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.setGroupName(name);
            GroupDAO groupDAO = new GroupDAO();
            boolean result = groupDAO.insertGroup(groupDTO);
            if (result) {
                url = Url.MANAGE_GROUP_PAGE;
                request.setAttribute("GROUP_LIST", groupDAO.getGroupList());
            }
        } catch (Exception e) {
            log("Error at InsertGroupController: " + e.getMessage());
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
