package nguyenvt.controllers.update;

import nguyenvt.daos.ProductDAO;
import nguyenvt.dtos.Cart;
import nguyenvt.utilities.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateCartController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            int id = Integer.parseInt(request.getParameter("txtId"));
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            ProductDAO productDAO = new ProductDAO();
            float unitPrice = productDAO.getUnitPrice(id);
            cart.updateCart(id, quantity, unitPrice);
            url = Url.VIEW_CART_PAGE;
        } catch (Exception e) {
            log("Error at UpdateCartController: " + e.getMessage());
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
