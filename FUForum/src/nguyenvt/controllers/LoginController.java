package nguyenvt.controllers;

import nguyenvt.daos.AccountDAO;
import nguyenvt.daos.GroupDAO;
import nguyenvt.daos.PostDAO;
import nguyenvt.dto.AccountDTO;
import nguyenvt.dto.GroupDTO;
import nguyenvt.stuff.Status;
import nguyenvt.stuff.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            AccountDAO accountDAO = new AccountDAO();
            AccountDTO accountDTO = accountDAO.checkLogin(username, password);
            if (accountDTO != null) {
                url = Url.HOME_PAGE;
                GroupDAO groupDAO = new GroupDAO();
                PostDAO postDAO = new PostDAO();
                List<GroupDTO> groupList = groupDAO.getGroupList();
                postDAO.getPostList();
                HttpSession session = request.getSession();
                session.setAttribute("ACCOUNT", accountDTO);
                session.setAttribute("GROUP", groupList);
                session.setAttribute("POST", postDAO.getPostDTOList());
                session.setAttribute("POSTER", postDAO.getAccountDTOList());
                session.setAttribute("POST_GROUP", postDAO.getGroupDTOList());
            } else {
                request.setAttribute("ERROR", "Oops! Something went wrong!");
            }
        } catch (Exception e) {
            log("Error at LoginController: " + e.getMessage());
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
