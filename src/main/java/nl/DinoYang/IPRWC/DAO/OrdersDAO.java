package nl.DinoYang.IPRWC.DAO;

import nl.DinoYang.IPRWC.Models.Orders;
import nl.DinoYang.IPRWC.Repositories.OrdersRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdersDAO {

    private final OrdersRepository ordersRepository;

    public OrdersDAO(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public void save(Orders order) {
        this.ordersRepository.save(order);
    }

    public List<Orders> getAllOrdersByUserId(Long id) {
        return this.ordersRepository.findAllByUserId(Math.toIntExact(id));
    }

    public List<Orders> getAll() {
        return this.ordersRepository.findAll();
    }
}
