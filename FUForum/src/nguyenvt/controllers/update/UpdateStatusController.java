package nguyenvt.controllers.update;

import nguyenvt.daos.PostDAO;
import nguyenvt.stuff.Status;
import nguyenvt.stuff.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateStatusController extends HttpServlet {
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            String action = request.getParameter("btnControl");
            int postId = Integer.parseInt(request.getParameter("txtPostId"));
            PostDAO postDAO = new PostDAO();
            boolean result = false;
            if (action.equals("Accept Post")) {
                result = postDAO.updateStatus(postId, Status.ACCEPT_STATUS);
            } else if (action.equals("Decline Post")){
                result = postDAO.updateStatus(postId, Status.ACCEPT_STATUS);
            }
            if (result) {
                url = Url.HOME_PAGE;
                HttpSession session = request.getSession();
                postDAO.getPostList();
                session.setAttribute("POST", postDAO.getPostDTOList());
                session.setAttribute("POSTER", postDAO.getAccountDTOList());
                session.setAttribute("POST_GROUP", postDAO.getGroupDTOList());
            }
        } catch (Exception e) {
            log("Error at UpdateStatusController: " + e.getMessage());
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
