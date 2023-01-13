package nl.DinoYang.IPRWC.Controllers;

import nl.DinoYang.IPRWC.DAO.CartDAO;
import nl.DinoYang.IPRWC.Exceptions.ResourceNotFoundException;
import nl.DinoYang.IPRWC.Models.ApiResponse;
import nl.DinoYang.IPRWC.Models.Cart;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartDAO cartDAO;

    public CartController(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    @GetMapping("/create/empty")
    public ApiResponse createEmptyCart() {
        Cart cart = new Cart();
        this.cartDAO.save(cart);
        return new ApiResponse(HttpStatus.ACCEPTED, cart.getId());
    }

    @PostMapping("/updateCart/{id}")
    public ApiResponse updateCartPrice(@PathVariable Long id, @RequestBody double price) {
        try {
            Cart cart = this.cartDAO.getCartById(id);
            cart.setTotalPrice(price);
            this.cartDAO.save(cart);
            return new ApiResponse(HttpStatus.ACCEPTED, "You've updated cart " + id);
        } catch (ResourceNotFoundException e) {
            return new ApiResponse(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/price/{cartId}")
    public ApiResponse getTotalPrice(@PathVariable Long cartId) {
        return new ApiResponse<>(HttpStatus.ACCEPTED, this.cartDAO.getTotalPriceById(cartId));
    }
}
