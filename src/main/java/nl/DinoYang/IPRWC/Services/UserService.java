package nl.DinoYang.IPRWC.Services;

import nl.DinoYang.IPRWC.Models.Role;
import nl.DinoYang.IPRWC.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void saveGebruiker(User user);

    boolean getUsernameDuplicate(String username);

    boolean getEmailDuplicate(String email);

    Role saveRol(Role role);

    void addRolAanGebruiker(String username, String roleName);

    User getGebruiker(String username);

    List<User> getGebruikers();
}
