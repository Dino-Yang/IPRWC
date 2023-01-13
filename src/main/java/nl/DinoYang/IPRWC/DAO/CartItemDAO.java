package nl.DinoYang.IPRWC.DAO;

import nl.DinoYang.IPRWC.Models.CartItem;
import nl.DinoYang.IPRWC.Repositories.CartItemRepository;
import org.springframework.stereotype.Component;

@Component
public class CartItemDAO {

    private final CartItemRepository cartItemRepository;

    public CartItemDAO(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void save(CartItem cartItem) {
        this.cartItemRepository.save(cartItem);
    }
}
