package nl.DinoYang.IPRWC.Controllers;

import nl.DinoYang.IPRWC.DAO.ProductDAO;
import nl.DinoYang.IPRWC.Exceptions.ResourceNotFoundException;
import nl.DinoYang.IPRWC.Models.ApiResponse;
import nl.DinoYang.IPRWC.Models.Product;
import nl.DinoYang.IPRWC.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductDAO productDAO;
    private ProductService productService;

    public ProductController(ProductDAO productDAO, ProductService productService) {
        this.productDAO = productDAO;
        this.productService = productService;
    }

    @PutMapping("/")
    public ApiResponse putProduct(@RequestBody Product product) {
        this.productDAO.save(product);
        return new ApiResponse<>(HttpStatus.ACCEPTED, "You've saved a product");
    }

    @PostMapping("/")
    public ApiResponse postProduct(@RequestBody Product product) {
        this.productDAO.save(product);
        return new ApiResponse<>(HttpStatus.ACCEPTED, "You've saved a product");
    }

    @GetMapping("/")
    public ApiResponse getAllProducts() {
        return new ApiResponse<>(HttpStatus.ACCEPTED, this.productDAO.getAll());
    }

    @GetMapping("/enabled/{enabled}")
    public ApiResponse getEnabledProducts(@PathVariable boolean enabled) {
        return new ApiResponse<>(HttpStatus.ACCEPTED, this.productDAO.getAllByEnabled(enabled));
    }

    @GetMapping("/{id}")
    public ApiResponse getProductById(@PathVariable Long id) {
        try {
            return new ApiResponse<>(HttpStatus.ACCEPTED, this.productDAO.getOneProduct(id));
        } catch (ResourceNotFoundException e) {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, e);
        }
    }

    @GetMapping("/cartId/{cartId}")
    public ApiResponse getProductsByCartId(@PathVariable Long cartId) {
        try {
            return new ApiResponse<>(HttpStatus.ACCEPTED, this.productService.getAllProductsByCartId(cartId));
        } catch (ResourceNotFoundException e) {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, e);
        }
    }
}
