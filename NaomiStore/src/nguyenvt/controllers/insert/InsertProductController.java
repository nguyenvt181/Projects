package nguyenvt.controllers.insert;

import nguyenvt.daos.ProductDAO;
import nguyenvt.dtos.ProductDTO;
import nguyenvt.utilities.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InsertProductController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            String name = request.getParameter("txtName");
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            float price = Float.parseFloat(request.getParameter("txtPrice"));
            ProductDTO productDTO = new ProductDTO(name, quantity, price);
            ProductDAO productDAO = new ProductDAO();
            boolean result = productDAO.insertProduct(productDTO);
            if (result){
                url = Url.HOME_PAGE;
                HttpSession session = request.getSession();
                session.setAttribute("PRODUCT", productDAO.getList());
            } else {
                url = Url.INSERT_PRODUCT_PAGE;
                request.setAttribute("ERROR", "Insert failed");
            }
        } catch (Exception e) {
            log("Error at InsertProductController: " + e.getMessage());
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
