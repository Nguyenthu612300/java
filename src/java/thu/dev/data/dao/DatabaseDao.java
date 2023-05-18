/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thu.dev.data.dao;

import thu.dev.data.dao.ProductDao;
import thu.dev.data.dao.UserDao;
import thu.dev.data.dao.CategoryDao;

/**
 *
 * @author Nguyen Thu
 */
public abstract class DatabaseDao {

    private static DatabaseDao instance;

    public static void init(DatabaseDao _instance) {
        instance = _instance;
    }

    public static DatabaseDao getInstance() {
        return instance;
    }

    public abstract UserDao getUserDao();

    public abstract ProductDao getProductDao();

    public abstract CategoryDao getCategoryDao();

    public abstract OrderDao getOrderDao();

    public abstract OrderDetailDao getOrderDetailDao();
}


