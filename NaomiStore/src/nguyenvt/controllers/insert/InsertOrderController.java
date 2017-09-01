package nguyenvt.controllers.insert;

import nguyenvt.daos.OrderDAO;
import nguyenvt.daos.OrderItemDAO;
import nguyenvt.daos.ProductDAO;
import nguyenvt.dtos.Cart;
import nguyenvt.dtos.OrderDTO;
import nguyenvt.dtos.OrderItemDTO;
import nguyenvt.dtos.ProductDTO;
import nguyenvt.utilities.ItemStatus;
import nguyenvt.utilities.Url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertOrderController extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = Url.ERROR_PAGE;
        try {
            float total = Float.parseFloat(request.getParameter("txtTotal"));
            int accountId = Integer.parseInt(request.getParameter("txtAccountId"));
            OrderDTO orderDTO = new OrderDTO(total, accountId, getCurrentDate());
            OrderDAO orderDAO = new OrderDAO();
            boolean result = orderDAO.insertOrder(orderDTO);
            if (result){
                HttpSession session = request.getSession();
                Cart cart = (Cart) session.getAttribute("CART");
                int orderId = orderDAO.getOrderId();
                for (ProductDTO x : cart.getHashMap().values()) {
                    int productId = x.getProductId();
                    float itemPrice = x.getProductPrice();
                    int itemQuantity = x.getProductQuantity();
                    ProductDAO productDAO = new ProductDAO();
                    int productQuantity = productDAO.getQuantity(productId);
                    boolean updateQuantity = productDAO.updateQuantity(productId, productQuantity - itemQuantity);
                    if (updateQuantity) {
                        OrderItemDTO itemDTO = new OrderItemDTO(itemPrice, ItemStatus.NORMAL_STATUS, "", "", productId, orderId);
                        OrderItemDAO itemDAO = new OrderItemDAO();
                        boolean insertItem = itemDAO.insertOrderItem(itemDTO);
                        if (insertItem) {
                            url = Url.HOME_PAGE;
                            session.setAttribute("PRODUCT", productDAO.getList());
                            session.removeAttribute("CART");
                        } else {
                            url = Url.ERROR_PAGE;
                            request.setAttribute("ERROR", "Oops! Something went wrong!");
                        }
                    } else {
                        url = Url.ERROR_PAGE;
                        request.setAttribute("ERROR", "Oops! Something went wrong!");
                    }
                }
            } else {
                url = Url.ERROR_PAGE;
                request.setAttribute("ERROR", "Oops! Something went wrong!");
            }
        } catch (Exception e) {
            log("Error at InsertOrderController: " + e.getMessage());
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

    protected String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
