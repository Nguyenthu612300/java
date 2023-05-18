package thu.dev.data.dao.impl;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import thu.dev.data.dao.OrderDetailDao;
import thu.dev.data.dao.model.OrderDetail;
import thu.dev.data.driver.MySQLDriver;

public class OrderDetailDaoImpl implements OrderDetailDao {

    private Connection conn;

    public OrderDetailDaoImpl() {
        this.conn = MySQLDriver.getInstance().getConnection();
    }

    @Override
    public boolean insert(OrderDetail orderdetail) {
        // TODO Auto-generated method stub
        try {
            String sql = "INSERT INTO ORDER_DETAILS(id, product_id, order_id, quantity, price) VALUES(NULL,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderdetail.getProductId());
            stmt.setInt(2, orderdetail.getOrderId());
            stmt.setInt(3, orderdetail.getQuantity());
            stmt.setDouble(4, orderdetail.getPrice());

            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean update(OrderDetail orderdetail) {
        // TODO Auto-generated method stub
        try {
            String sql = "UPDATE ORDER_DETAILS SET PRODUCT_ID=?, ORDER_ID =? ,QUANTITY=?, PRICE=? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderdetail.getProductId());
            stmt.setInt(2, orderdetail.getOrderId());
            stmt.setInt(3, orderdetail.getQuantity());
            stmt.setDouble(4, orderdetail.getPrice());

            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        try {
            String sql = "DELETE FROM ORDER_DETAILS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public OrderDetail find(int id) {
        // TODO Auto-generated method stub
        try {
            String sql = "SELECT * FROM ORDER_DETAILS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = (ResultSet) stmt.executeQuery();
            if (rs.next()) {
                int product_id = rs.getInt("product_id");
                int order_id = rs.getInt("order_id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                return new OrderDetail(id, product_id, order_id, quantity, price);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<OrderDetail> findAll() {
        // TODO Auto-generated method stub
        List<OrderDetail> orderdetailList = new ArrayList<OrderDetail>();
        try {
            String sql = "SELECT * FROM ORDER_DETAILS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int product_id = rs.getInt("product_id");
                int order_id = rs.getInt("order_id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                orderdetailList.add(new OrderDetail(id, product_id, order_id, quantity, price));
            }
        } catch (SQLException ex) {
        }

        return orderdetailList;
    }

    @Override
    public List<OrderDetail> all() {
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        String sql = "SELECT * FROM orders_details";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                int productId = rs.getInt("product_id");
                int orderId = rs.getInt("order_id");
                
                orderDetailList.add(new OrderDetail(id, quantity, productId, orderId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderDetailList;
    }

     @Override
    public List<OrderDetail> findByOrder(int orderId) {
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        String sql = "SELECT * FROM orders_details WHERE order_id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                int productId = rs.getInt("product_id");
                
                orderDetailList.add(new OrderDetail(id, quantity, productId, orderId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderDetailList;
    }

}
