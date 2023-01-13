package nl.DinoYang.IPRWC.Repositories;

import nl.DinoYang.IPRWC.Models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    UserDetails findUserDetailsByUserId(int id);

    boolean existsUserDetailsByUserId(int id);

}
