package nl.DinoYang.IPRWC.DAO;

import nl.DinoYang.IPRWC.Models.Role;
import nl.DinoYang.IPRWC.Models.User;
import nl.DinoYang.IPRWC.Repositories.RoleRepository;
import nl.DinoYang.IPRWC.Repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserDAO(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User getUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    public void saveUserToDatabase(User user) {
        this.userRepository.save(user);
    }

    public Role saveRoleToDatabase(Role role) {
        this.roleRepository.save(role);
        return role;
    }
}
