package nl.DinoYang.IPRWC.Repositories;

import nl.DinoYang.IPRWC.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
