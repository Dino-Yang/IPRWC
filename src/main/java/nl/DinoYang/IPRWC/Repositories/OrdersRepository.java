package nl.DinoYang.IPRWC.Repositories;

import nl.DinoYang.IPRWC.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAllByUserId(int userId);
}
