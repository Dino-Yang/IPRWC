package nl.DinoYang.IPRWC.Repositories;

import nl.DinoYang.IPRWC.Models.ShippingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingDetailsRepository extends JpaRepository<ShippingDetails, Long> {

    ShippingDetails findShippingDetailsByOrderId(int orderId);
}
