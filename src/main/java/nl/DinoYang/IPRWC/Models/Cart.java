package nl.DinoYang.IPRWC.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cart", schema = "iprwc")
public class Cart {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "total_price")
    private double totalPrice;
    @OneToMany(mappedBy = "cart")
    private List<CartItem> CartItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getCartItems() {
        return CartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.CartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", CartItems=" + CartItems +
                '}';
    }
}
