package thu.dev.data.dao;

import java.util.List;

import thu.dev.data.dao.model.Category;

public interface CategoryDao {

    public boolean insert(Category category);

    public boolean update(Category category);

    public boolean delete(int id);

    public List<Category> all();

    public Category find(int id);

    public List<Category> findAll();

    public Category findByName(String name);

    
}
