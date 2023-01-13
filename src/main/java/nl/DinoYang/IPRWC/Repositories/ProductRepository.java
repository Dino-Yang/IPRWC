package nl.DinoYang.IPRWC.Repositories;

import nl.DinoYang.IPRWC.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByEnabled(boolean enabled);
}
