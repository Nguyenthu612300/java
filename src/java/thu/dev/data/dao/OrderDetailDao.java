package thu.dev.data.dao;

import java.util.List;

import thu.dev.data.dao.model.OrderDetail;

public interface OrderDetailDao {

    public boolean insert(OrderDetail orderdetail);

    public boolean update(OrderDetail orderdetail);

    public boolean delete(int id);

    public OrderDetail find(int id);

    public List<OrderDetail> findAll();

    public List<OrderDetail> all();

    public List<OrderDetail> findByOrder(int id);
}
