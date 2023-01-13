package nl.DinoYang.IPRWC.Controllers;

import lombok.RequiredArgsConstructor;
import nl.DinoYang.IPRWC.Models.ApiResponse;
import nl.DinoYang.IPRWC.Models.User;
import nl.DinoYang.IPRWC.Services.UserServiceImplemention;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/")
public class UserController {

    private final UserServiceImplemention userService;


    @GetMapping("/{username}")
    public ApiResponse<User> getUser(@PathVariable String username) {
        return new ApiResponse<>(HttpStatus.ACCEPTED, this.userService.getGebruiker(username));
    }

    @GetMapping("/all/")
    public ApiResponse getAll() {
        return new ApiResponse<>(HttpStatus.ACCEPTED, this.userService.getGebruikers());
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public ApiResponse putUser(@RequestBody User user) {
        this.userService.saveGebruiker(user);
        this.userService.addRolAanGebruiker(user.getUsername(), "ROLE_USER");
        return new ApiResponse<>(HttpStatus.ACCEPTED, "User password changed!");
    }

    @PostMapping("/")
    public ApiResponse<String> saveUser(@RequestBody User user) {
        System.out.println(user.toString());
        this.userService.saveGebruiker(user);
        this.userService.addRolAanGebruiker(user.getUsername(), "ROLE_USER");
        return new ApiResponse<>(HttpStatus.ACCEPTED, "User created!");
    }

    @PostMapping("/admins/")
    public ApiResponse<String> saveAdmin(@RequestBody User user) {
        this.userService.saveGebruiker(user);
        this.userService.addRolAanGebruiker(user.getUsername(), "ROLE_ADMIN");
        this.userService.addRolAanGebruiker(user.getUsername(), "ROLE_USER");
        return new ApiResponse<>(HttpStatus.ACCEPTED, "User created!");
    }

    @PostMapping("/username/check")
    public boolean checkUsername(@RequestBody String username) {
        return this.userService.getUsernameDuplicate(username);
    }

    @PostMapping("/email/check")
    public boolean checkEmail(@RequestBody String email) {
        return this.userService.getEmailDuplicate(email);
    }

}
