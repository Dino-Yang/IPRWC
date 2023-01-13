package nl.DinoYang.IPRWC.Services;

import nl.DinoYang.IPRWC.DAO.CartDAO;
import nl.DinoYang.IPRWC.DAO.CartItemDAO;
import nl.DinoYang.IPRWC.DAO.ProductDAO;
import nl.DinoYang.IPRWC.Models.CartItem;
import nl.DinoYang.IPRWC.Models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public final CartDAO cartDAO;
    public final CartItemDAO cartItemDAO;
    public final ProductDAO productDAO;

    public ProductService(CartDAO cartDAO, CartItemDAO cartItemDAO, ProductDAO productDAO) {
        this.cartDAO = cartDAO;
        this.cartItemDAO = cartItemDAO;
        this.productDAO = productDAO;
    }

    public List<Product> getAllProductsByCartId(Long cartId) {
        List<Product> productList = new ArrayList<>();
        List<CartItem> listItems = this.cartDAO.getCartById(cartId).getCartItems();
        for (CartItem item : listItems) {
            productList.add(this.productDAO.getOneProduct(item.getProductId()));
        }
        return productList;
    }
}
