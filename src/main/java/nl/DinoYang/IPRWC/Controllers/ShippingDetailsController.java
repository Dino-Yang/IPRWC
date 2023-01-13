package nl.DinoYang.IPRWC.Controllers;

import nl.DinoYang.IPRWC.DAO.ShippingDetailsDAO;
import nl.DinoYang.IPRWC.Models.ApiResponse;
import nl.DinoYang.IPRWC.Models.ShippingDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipping/")
public class ShippingDetailsController {

    private final ShippingDetailsDAO shippingDetailsDAO;

    public ShippingDetailsController(ShippingDetailsDAO shippingDetailsDAO) {
        this.shippingDetailsDAO = shippingDetailsDAO;
    }

    @GetMapping("{orderId}")
    public ApiResponse getShippingDetailsByOrderId(@PathVariable Long orderId) {
        return new ApiResponse(HttpStatus.OK, this.shippingDetailsDAO.getShippingDetailsByOrderId(orderId));
    }

    @PostMapping("")
    public ApiResponse save(@RequestBody ShippingDetails shippingDetails) {
        this.shippingDetailsDAO.save(shippingDetails);
        return new ApiResponse(HttpStatus.OK,
                "You've saved a shipping detail with id: " + shippingDetails.getOrderId());
    }
}
