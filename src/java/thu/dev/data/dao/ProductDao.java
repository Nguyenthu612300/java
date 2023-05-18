package thu.dev.data.dao;

import java.util.List;

import thu.dev.data.dao.model.Product;

public interface ProductDao {

    public boolean insert(Product product);

    public boolean update(Product product);

    public boolean delete(int id);

    public Product find(int id);

    public List<Product> findALL();

    public List<Product> all();

    public List<Product> searchByName(String productName);

    public List<Product> findByCategoryId(int id);

    public ProductDao findByName(String name);

    public int countProduct();

}
