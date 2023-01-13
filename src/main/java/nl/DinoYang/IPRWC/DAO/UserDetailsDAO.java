package nl.DinoYang.IPRWC.DAO;

import nl.DinoYang.IPRWC.Models.UserDetails;
import nl.DinoYang.IPRWC.Repositories.UserDetailsRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsDAO {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsDAO(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    public List<UserDetails> getAll() {
        return this.userDetailsRepository.findAll();
    }

    public UserDetails getByUserId(int id) {
        return this.userDetailsRepository.findUserDetailsByUserId(id);
    }

    public void save(UserDetails userDetails) {
        this.userDetailsRepository.save(userDetails);
    }

    public boolean userDetailsExist(int id) {
        return this.userDetailsRepository.existsUserDetailsByUserId(id);
    }
}
