/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package thu.dev;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import thu.dev.data.dao.DatabaseDao;
import thu.dev.data.dao.ProductDao;
import thu.dev.data.dao.model.OrderDetailSession;
import thu.dev.data.dao.model.Product;

/**
 *
 * @author Nguyen Thu
 */
public class OrderServlet extends BaseServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action) {
            case "creat":
                create(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                throw new AssertionError();
        }
        response.sendRedirect("CartServlet");
    }
    
    private void create(HttpServletRequest request, HttpServletResponse response){
        String productName = request.getParameter("productName");
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        String img = request.getParameter("img");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price").trim());
        
        OrderDetailSession orderDetailSession = new OrderDetailSession(product_id, productName, img, price, quantity);
        
        HttpSession session = request.getSession();
        List<OrderDetailSession> cart = null;
        
        boolean productExist = false;
        
        if(session.getAttribute("cart") == null){
            //Lan dau tien dua vao gio hang
            cart = new ArrayList<OrderDetailSession>();   
        }else{
            cart = (List<OrderDetailSession>)session.getAttribute("cart");
            for (OrderDetailSession ods : cart) {
                if(ods.getProductId() == orderDetailSession.getProductId()){
                    ods.setQuantity(ods.getQuantity() + quantity);
                    productExist = true;
                    break;
                }
            }
        }
        
        if(!productExist) cart.add(orderDetailSession);
        
        session.setAttribute("cart", cart); 
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        HttpSession session = request.getSession();
        List<OrderDetailSession> cart = null;
        if(session.getAttribute("cart") != null){
            cart = (List<OrderDetailSession>)session.getAttribute("cart");
            for (OrderDetailSession ods : cart) {
                if(ods.getProductId() == product_id){
                    cart.remove(ods);
                    break;
                }
            }
        }
        
        session.setAttribute("cart", cart); 
    }

}
