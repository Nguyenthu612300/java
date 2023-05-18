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
import thu.dev.data.dao.CategoryDao;
import thu.dev.data.dao.DatabaseDao;
import thu.dev.data.dao.ProductDao;
import thu.dev.data.dao.model.Category;
import thu.dev.data.dao.model.Product;

/**
 *
 * @author User
 */
public class EditProductServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.all();

        req.setAttribute("categoryList", categoryList);

        int productId = Integer.parseInt(req.getParameter("productId"));

        ProductDao ProductDao = DatabaseDao.getInstance().getProductDao();
        Product product = ProductDao.find(productId);

        req.setAttribute("product", product);
        req.getRequestDispatcher("admin/products/edit.jsp").include(req, resp);
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
            throws ServletException, IOException, NumberFormatException {

        int productId = Integer.parseInt(req.getParameter("productId"));

        ProductDao ProductDao = DatabaseDao.getInstance().getProductDao();
        Product product = ProductDao.find(productId);

        String name = req.getParameter("name");

        String description = req.getParameter("desc");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String img = req.getParameter("img");

        product.setName(name);

        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategoryId(categoryId);
        product.setImg(img);

        ProductDao.update(product);

        resp.sendRedirect("IndexProductServlet");
    }
}
