package thu.dev.data.dao.impl;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

import thu.dev.data.dao.OrderDao;
import thu.dev.data.dao.model.Order;
import thu.dev.data.driver.MySQLDriver;

public class OrderDaoImpl implements OrderDao {

    private Connection conn;

    public OrderDaoImpl() {
        this.conn = MySQLDriver.getInstance().getConnection();
    }

    @Override
    public boolean insert(Order order) {
        // TODO Auto-generated method stub
        try {
            String sql = "INSERT INTO ORDERS(id, code, status, user_id) VALUES(NULL, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, order.getCode());
            stmt.setString(2, order.getStatus());
            stmt.setInt(3, order.getUserId());

            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean update(Order order) {
        // TODO Auto-generated method stub
        try {
            String sql = "UPDATE ORDERS SET CODE=?, STATUS=?, USER_ID =? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, order.getCode());
            stmt.setString(2, order.getStatus());
            stmt.setInt(3, order.getUserId());
            return stmt.execute();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        try {
            String sql = "DELETE FROM ORDERS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public Order find(int id) {
        // TODO Auto-generated method stub
        try {
            String sql = "SELECT * FROM ORDERS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = (ResultSet) stmt.executeQuery();
            if (rs.next()) {
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                return new Order(id, code, status, userId);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        // TODO Auto-generated method stub
        List<Order> orderList = new ArrayList<Order>();
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM ORDERS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                orderList.add(new Order(id, code, status, userId));
            }
        } catch (SQLException ex) {

        }

        return orderList;
    }

    @Override
    public Order find(String code) {
        Connection conn = MySQLDriver.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM ORDERS WHERE CODE = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                return new Order(id, code, status, userId);
            }

        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public int countOrder() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int countPendingOrder() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Order> all() {
        List<Order> orderList = new ArrayList<Order>();
        String sql = "SELECT * FROM ORDERS";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");

                orderList.add(new Order(id, code, status, userId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderList;
    }

    @Override
    public Object findALL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Order> findByStatus(String pending) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer countOrderByDay(String get) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
