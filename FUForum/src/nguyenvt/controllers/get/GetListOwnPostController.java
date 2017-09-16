package nguyenvt.controllers.get;

import nguyenvt.daos.PostDAO;
import nguyenvt.stuff.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetListOwnPostController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            int accountId = Integer.parseInt(request.getParameter("txtAccountId"));
            PostDAO postDAO = new PostDAO();
            postDAO.getOwnPost(accountId);
            request.setAttribute("POST", postDAO.getPostDTOList());
            request.setAttribute("POST_GROUP", postDAO.getGroupDTOList());
            url = Url.VIEW_OWN_POST_PAGE;
        } catch (Exception e) {
            log("Error at GetListOwnPostController: " + e.getMessage());
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
