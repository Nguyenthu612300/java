package thu.dev.data.dao.impl;

//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import thu.dev.data.dao.CategoryDao;
import thu.dev.data.dao.model.Category;
import thu.dev.data.dao.model.Product;
import thu.dev.data.driver.MySQLDriver;

public class CategoryDaoImpl implements CategoryDao {

    private Connection conn;

    public CategoryDaoImpl() {
        this.conn = MySQLDriver.getInstance().getConnection();
    }

    @Override
    public boolean insert(Category category) {
        // TODO Auto-generated method stub
        try {
            String sql = "INSERT INTO CATEGORIES(ID, NAME, IMAGE) VALUES(NULL,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getimage());

            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        // TODO Auto-generated method stub
        try {
            String sql = "UPDATE CATEGORIES SET NAME=?, IMAGE=? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getimage());
             stmt.setInt(3, category.getId());
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

            String sql = "DELETE FROM CATEGORIES WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            return stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    public List<Category> all() {
        List<Category> categoryList = new ArrayList<Category>();
        String sql = "SELECT * FROM CATEGORIES";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");

                categoryList.add(new Category(id, name, image));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoryList;
    }

    @Override
    public Category find(int id) {
        // TODO Auto-generated method stub
        try {
            String sql = "SELECT * FROM CATEGORIES WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                return new Category(id, name, image);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        // TODO Auto-generated method stub
        List<Category> categoryList = new ArrayList<Category>();

        try {
            String sql = "SELECT * FROM CATEGORIES";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");

                categoryList.add(new Category(id, name, image));
            }
        } catch (SQLException ex) {
        }

        return categoryList;
    }

    @Override
    public Category findByName(String name) {
        String sql = "SELECT * FROM CATEGORIES WHERE NAME=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String desc = rs.getString("description");

                return new Category(id, name, desc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
