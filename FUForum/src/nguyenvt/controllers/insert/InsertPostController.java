package nguyenvt.controllers.insert;

import nguyenvt.daos.PostDAO;
import nguyenvt.dto.PostDTO;
import nguyenvt.stuff.Status;
import nguyenvt.stuff.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class InsertPostController extends HttpServlet {
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = Url.ERROR_PAGE;
        try {
            String title = request.getParameter("txtTitle");
            String content = request.getParameter("txtContent");
            int group = Integer.parseInt(request.getParameter("txtGroup"));
            int accountId = Integer.parseInt(request.getParameter("txtAccountId"));
            PostDTO postDTO = new PostDTO(title, content, getCurrentDate(), accountId, group, Status.REQUEST_STATUS);
            PostDAO postDAO = new PostDAO();
            boolean result = postDAO.insertPost(postDTO);
            if (result) {
                url = Url.HOME_PAGE;
                HttpSession session = request.getSession();
                postDAO.getPostList();
                session.setAttribute("POST", postDAO.getPostDTOList());
                session.setAttribute("POSTER", postDAO.getAccountDTOList());
                session.setAttribute("POST_GROUP", postDAO.getGroupDTOList());
            } else {
                request.setAttribute("ERROR", "Oops! Something went wrong!");
            }
        } catch (Exception e) {
            log("Error at InsertPostController: " + e.getMessage());
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

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
