package nguyenvt.controllers.remove;

import nguyenvt.daos.ProductDAO;
import nguyenvt.utilities.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RemoveProductController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            int id = Integer.parseInt(request.getParameter("txtId"));
            ProductDAO productDAO = new ProductDAO();
            boolean result = productDAO.removeProduct(id);
            if (result){
                url = Url.HOME_PAGE;
                HttpSession session = request.getSession();
                session.setAttribute("PRODUCT", productDAO.getList());
            } else {
                request.setAttribute("ERROR", "Remove Product Failed");
            }
        } catch (Exception e) {
            log("Error at RemoveProductController: " + e.getMessage());
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
