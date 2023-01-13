package nl.DinoYang.IPRWC.Controllers;

import nl.DinoYang.IPRWC.DAO.CartDAO;
import nl.DinoYang.IPRWC.DAO.CartItemDAO;
import nl.DinoYang.IPRWC.Models.ApiResponse;
import nl.DinoYang.IPRWC.Models.CartItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart/item")
public class CartItemController {
    private final CartItemDAO cartItemDAO;
    private final CartDAO cartDAO;

    public CartItemController(CartItemDAO cartItemDAO, CartDAO cartDAO) {
        this.cartItemDAO = cartItemDAO;
        this.cartDAO = cartDAO;
    }

    @PostMapping("/{cartId}")
    public ApiResponse postCartItem(@RequestBody CartItem cartItem, @PathVariable Long cartId) {
        cartItem.setCart(this.cartDAO.getCartById(cartId));
        this.cartItemDAO.save(cartItem);
        return new ApiResponse<>(HttpStatus.ACCEPTED, "You've posted a CartItem");
    }


}
