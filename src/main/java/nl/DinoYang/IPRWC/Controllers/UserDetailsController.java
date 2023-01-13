package nl.DinoYang.IPRWC.Controllers;

import lombok.RequiredArgsConstructor;
import nl.DinoYang.IPRWC.DAO.UserDetailsDAO;
import nl.DinoYang.IPRWC.Models.ApiResponse;
import nl.DinoYang.IPRWC.Models.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/details")
public class UserDetailsController {

    private final UserDetailsDAO userDetailsDAO;

    @GetMapping("")
    public ApiResponse getAllUserDetails() {
        return new ApiResponse<>(HttpStatus.ACCEPTED, this.userDetailsDAO.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse getUserDetailsByUserId(@PathVariable int id) {
        return new ApiResponse<>(HttpStatus.ACCEPTED, this.userDetailsDAO.getByUserId(id));
    }

    @GetMapping("/exist/{id}")
    public ApiResponse getHasUserDetailsByUserId(@PathVariable int id) {
        return new ApiResponse<>(HttpStatus.ACCEPTED, this.userDetailsDAO.userDetailsExist(id));
    }

    @PostMapping("")
    public ApiResponse save(@RequestBody UserDetails userDetails) {
        System.out.println(userDetails.toString());
        this.userDetailsDAO.save(userDetails);
        return new ApiResponse<>(HttpStatus.ACCEPTED, "You've saved user details for user " + userDetails.getUserId());
    }
}
