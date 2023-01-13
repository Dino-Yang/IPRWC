package nl.DinoYang.IPRWC.DAO;

import nl.DinoYang.IPRWC.Exceptions.ResourceNotFoundException;
import nl.DinoYang.IPRWC.Models.Cart;
import nl.DinoYang.IPRWC.Repositories.CartRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CartDAO {

    private final CartRepository cartRepository;

    public CartDAO(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void save(Cart cart) {
        this.cartRepository.save(cart);
    }

    public Cart getCartById(Long id) throws ResourceNotFoundException {
        Optional<Cart> cart = this.cartRepository.findById(id);
        if (cart.isEmpty()) {
            throw new ResourceNotFoundException("cart does not exist");
        }
        return cart.get();
    }

    public double getTotalPriceById(Long id) throws ResourceNotFoundException {
        Optional<Cart> cart = this.cartRepository.findById(id);
        if (cart.isEmpty()) {
            throw new ResourceNotFoundException("cart does not exist");
        }
        return cart.get().getTotalPrice();
    }
}
