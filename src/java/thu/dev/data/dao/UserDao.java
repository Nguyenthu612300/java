package thu.dev.data.dao;

import java.util.List;

import thu.dev.data.dao.model.User;

public interface UserDao {

    public boolean insert(User user);

    public boolean update(User user);

    public boolean delete(int id);

    public User find(int id);

    public List<User> findAll();

    public User findByEmail(String email);

    public User find(String email, String password);

    public User login(String email, String password);

    public User register(String email, String password);

    public int countUser();

  
}
