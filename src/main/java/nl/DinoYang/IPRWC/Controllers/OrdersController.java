package nl.DinoYang.IPRWC.Controllers;

import nl.DinoYang.IPRWC.DAO.OrdersDAO;
import nl.DinoYang.IPRWC.Models.ApiResponse;
import nl.DinoYang.IPRWC.Models.Orders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    private final OrdersDAO ordersDAO;

    public OrdersController(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }

    @PostMapping("/")
    public ApiResponse saveOrder(@RequestBody Orders order) {
        this.ordersDAO.save(order);
        return new ApiResponse(HttpStatus.OK, order.getId());
    }

    @GetMapping("/userId/{id}")
    public ApiResponse getOrdersByUserId(@PathVariable Long id) {
        return new ApiResponse(HttpStatus.OK, this.ordersDAO.getAllOrdersByUserId(id));
    }

    @GetMapping("/")
    public ApiResponse getAllOrders() {
        return new ApiResponse(HttpStatus.OK, this.ordersDAO.getAll());
    }
}
