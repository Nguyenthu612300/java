/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package thu.dev.admin.product;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;
import thu.dev.admin.BaseAdminServlet;
import thu.dev.data.dao.CategoryDao;
import thu.dev.data.dao.DatabaseDao;
import thu.dev.data.dao.ProductDao;
import thu.dev.data.dao.model.Category;
import thu.dev.data.dao.model.Product;

/**
 *
 * @author Admin
 */
public class CreateProductServlet extends BaseAdminServlet {

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
//        super.doGet(req, resp);
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.all();
        
        req.setAttribute("categoryList", categoryList);
        
        req.getRequestDispatcher("admin/products/create.jsp").include(req, resp);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req servlet req
     * @param resp servlet resp
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doGet(req, resp);
        String name = req.getParameter("name");
        String img = req.getParameter("img");
        String desc = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        Timestamp createdAt = null;
        Product product = new Product(name, desc, price, quantity, quantity, createdAt, categoryId, img);
        
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        productDao.insert(product);
        
        resp.sendRedirect("IndexProductServlet");
    }

}

