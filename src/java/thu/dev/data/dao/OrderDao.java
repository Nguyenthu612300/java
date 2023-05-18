package thu.dev.data.dao;

import java.util.List;

import thu.dev.data.dao.model.Order;

public interface OrderDao {

    public boolean insert(Order order);

    public boolean update(Order order);

    public boolean delete(int id);

    public Order find(int id);

    public List<Order> findAll();

//    public Order findByCode(String code);

    public Order find(String code);

    public int countOrder();

    public int countPendingOrder();

    public List<Order> all();

    public Object findALL();

    public List<Order> findByStatus(String pending);

    public Integer countOrderByDay(String get);
}
