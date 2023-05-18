package thu.dev;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import thu.dev.data.dao.ProductDao;
import thu.dev.data.dao.UserDao;
import thu.dev.data.dao.impl.ProductDaoImpl;
import thu.dev.data.dao.impl.UserDaoImpl;
import thu.dev.data.dao.model.User;
import thu.dev.data.dao.model.Product;

public class MainApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        UserDao userDao = new UserDaoImpl();
//        User user = new User("thu1234@gmail.com", "abc", "admin");
//        userDao.insert(user);
        ProductDao productDao = new ProductDaoImpl();
        Product product = new Product("ổi ", "ok", 200, 10, 10, Timestamp.valueOf(LocalDateTime.now()), 3,"123");
        productDao.insert(product);
    }

}
