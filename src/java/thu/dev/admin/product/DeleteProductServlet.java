/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package thu.dev.admin.product;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import thu.dev.admin.BaseAdminServlet;
import thu.dev.data.dao.DatabaseDao;
import  thu.dev.data.dao.ProductDao;

/**
 *
 * @author Admin
 */
public class DeleteProductServlet extends BaseAdminServlet {

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
        int productId = Integer.parseInt(req.getParameter("productId"));
        ProductDao ProductDao = DatabaseDao.getInstance().getProductDao();
        ProductDao.delete(productId);
        
        resp.sendRedirect("IndexProductServlet");
        
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
        super.doGet(req, resp);
    }


}
