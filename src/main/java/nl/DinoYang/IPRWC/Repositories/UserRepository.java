package nl.DinoYang.IPRWC.Repositories;

import nl.DinoYang.IPRWC.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}