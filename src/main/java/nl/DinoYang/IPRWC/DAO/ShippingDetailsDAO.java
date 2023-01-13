package nl.DinoYang.IPRWC.DAO;

import nl.DinoYang.IPRWC.Models.ShippingDetails;
import nl.DinoYang.IPRWC.Repositories.ShippingDetailsRepository;
import org.springframework.stereotype.Component;

@Component
public class ShippingDetailsDAO {

    private final ShippingDetailsRepository shippingDetailsRepository;

    public ShippingDetailsDAO(ShippingDetailsRepository shippingDetailsRepository) {
        this.shippingDetailsRepository = shippingDetailsRepository;
    }

    public void save(ShippingDetails shippingDetails) {
        this.shippingDetailsRepository.save(shippingDetails);
    }

    public ShippingDetails getShippingDetailsByOrderId(Long orderId) {
        return this.shippingDetailsRepository.findShippingDetailsByOrderId(Math.toIntExact(orderId));
    }
}
