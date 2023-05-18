/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package thu.dev.admin.category;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import thu.dev.admin.BaseAdminServlet;
import thu.dev.data.dao.CategoryDao;
import thu.dev.data.dao.DatabaseDao;
import thu.dev.data.dao.model.Category;
/**
 *
 * @author Admin
 */
public class EditCategoryServlet extends BaseAdminServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req
     * @param resp
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
  
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        Category category = categoryDao.find(categoryId);
        
        req.setAttribute("category", category);
        req.getRequestDispatcher("admin/categories/edit.jsp").include(req, resp);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req
     * @param resp
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    
         int categoryId = Integer.parseInt(req.getParameter("categoryId"));
          
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        Category category = categoryDao.find(categoryId);
        
        String name = req.getParameter("name");
        String image = req.getParameter("image");
        category.setName(name);
        category.setimage(image);
        
        categoryDao.update(category);
        
        resp.sendRedirect("IndexCategoryServlet");
    }
}
