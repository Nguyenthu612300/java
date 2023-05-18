/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package thu.dev.admin.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import thu.dev.BaseServlet;
import thu.dev.admin.BaseAdminServlet;
import thu.dev.data.dao.DatabaseDao;
import thu.dev.data.dao.ProductDao;
import thu.dev.data.dao.model.Product;

/**
 *
 * @author User
 */
public class IndexProductServlet extends BaseAdminServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req servlet req
     * @param resp servlet resp
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = productDao.all();
        
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("admin/products/index.jsp").include(req, resp);
    }
    
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       
    }

}
