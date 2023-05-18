package thu.dev.data.dao.impl;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import thu.dev.data.dao.ProductDao;
import thu.dev.data.dao.model.Product;
import thu.dev.data.dao.model.User;
import thu.dev.data.driver.MySQLDriver;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDao {

    private Connection conn;

    public ProductDaoImpl() {
        this.conn = MySQLDriver.getInstance().getConnection();
    }

    @Override
    public boolean insert(Product product) {
        try {
            String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, PRICE, QUANTITY, VIEW, CATEGORY_ID, CREATED_AT,IMG)VALUES(NULL, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.setInt(5, product.getView());
            stmt.setInt(6, product.getCategoryId());
            stmt.setTimestamp(7, product.getCreatedAt());
            stmt.setString(8, product.getImg());
            return stmt.execute();

        } catch (SQLException e) {
            // TODO: handle exception

        }
        return false;

    }

    @Override
    public boolean update(Product product) {
        try {
            String sql = "UPDATE PRODUCTS SET NAME=?, DESCRIPTION=?, PRICE=?, QUANTITY=?, VIEW=?, CATEGORY_ID=?, CREATED_AT=?, IMG=?, WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.setInt(5, product.getView());
            stmt.setInt(6, product.getCategoryId());
            stmt.setTimestamp(7, product.getCreatedAt());
            stmt.setString(8, product.getImg());
            stmt.setInt(9, product.getId());
            return stmt.execute();

        } catch (SQLException e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM PRODUCTS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.execute();

        } catch (SQLException e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public Product find(int id) {
        try {
            String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                String img = rs.getString("img");
                return new Product(id, name, description, price, quantity, view, createdAt, categoryId, img);
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<Product> findALL() {
        List<Product> productList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PRODUCTS";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String descripton = rs.getString("description");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                Integer view = rs.getInt("view");
                Integer categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                String img = rs.getString("img");
                productList.add(new Product(id, name, descripton, price, quantity, view, createdAt, categoryId, img));
            }
        } catch (SQLException ex) {
            // TODO: handle exception
        }
        return productList;
    }

    @Override
    public List<Product> searchByName(String productName) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT * FROM PRODUCTS WHERE NAME like ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + productName + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String descripton = rs.getString("description");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                Integer view = rs.getInt("view");
                Integer categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                String img = rs.getString("img");

                productList.add(new Product(id, name, descripton, price, quantity, view, createdAt, categoryId, img));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT * FROM PRODUCTS WHERE category_id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String descripton = rs.getString("description");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                Integer view = rs.getInt("view");

                Timestamp createdAt = rs.getTimestamp("created_at");
                String img = rs.getString("img");

                productList.add(new Product(id, name, descripton, price, quantity, view, createdAt, categoryId, img));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    @Override
    public List<Product> all() {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT * FROM PRODUCTS";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String descripton = rs.getString("description");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                Integer view = rs.getInt("view");
                Integer categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                String img = rs.getString("img");

                productList.add(new Product(id, name, descripton, price, quantity, view, createdAt, categoryId, img));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    @Override
    public ProductDao findByName(String name) {
        String sql = "SELECT * FROM PRODUCTS WHERE NaME=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");

                String descripton = rs.getString("description");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                Integer view = rs.getInt("view");
                Integer categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                String img = rs.getString("img");

                return (ProductDao) new Product(id, name, descripton, price, quantity, view, createdAt, categoryId, img);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int countProduct() {
        String sql = "SELECT COUNT(*) AS count FROM products";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int countProduct = rs.getInt("count");
                return countProduct;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
