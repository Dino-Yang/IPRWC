package nl.DinoYang.IPRWC.DAO;

import nl.DinoYang.IPRWC.Exceptions.ResourceNotFoundException;
import nl.DinoYang.IPRWC.Models.Product;
import nl.DinoYang.IPRWC.Repositories.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDAO {

    private final ProductRepository productRepository;

    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    public List<Product> getAllByEnabled(boolean enabled) {
        return this.productRepository.findAllByEnabled(enabled);
    }

    public Product getOneProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ResourceNotFoundException("product with id " + id + " not found");
        }
    }

    public void save(Product product) {
        this.productRepository.save(product);
    }
}
