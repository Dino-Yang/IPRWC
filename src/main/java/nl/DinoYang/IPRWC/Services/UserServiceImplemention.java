package nl.DinoYang.IPRWC.Services;

import lombok.extern.slf4j.Slf4j;
import nl.DinoYang.IPRWC.DAO.UserDAO;
import nl.DinoYang.IPRWC.Models.Role;
import nl.DinoYang.IPRWC.Models.User;
import nl.DinoYang.IPRWC.Repositories.RoleRepository;
import nl.DinoYang.IPRWC.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Dino Yang
 */
@Service
@Transactional
@Slf4j
public class UserServiceImplemention implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository rolRepository;
    private final UserDAO userDAO;

    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Constructor
     *
     * @param userRepository takes the user repository
     * @param rolRepository  takes the rolerepository
     * @param userDAO        takes the userDAO
     */
    public UserServiceImplemention(UserRepository userRepository, RoleRepository rolRepository, UserDAO userDAO) {
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
        this.userDAO = userDAO;
    }

    /**
     * checks if the user exists in the databases, and grants authorities to the user
     *
     * @param username takes the username
     * @return rteurns the user, with the details
     * @throws UsernameNotFoundException when the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException("Gebruiker niet gevonden");
        else log.info("Gebruiker aanwezig in database");
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }

    /**
     * saves an user
     *
     * @param user takes the user to save
     */
    @Override
    public void saveGebruiker(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        user.setRoles(new ArrayList<>());
        this.userDAO.saveUserToDatabase(user);
    }

    @Override
    public boolean getUsernameDuplicate(String username) {
        List<User> users = getGebruikers();
        return containsName(users, username);
    }

    @Override
    public boolean getEmailDuplicate(String email) {
        List<User> users = getGebruikers();
        return containsEmail(users, email);
    }

    public boolean containsName(final List<User> list, final String name) {
        return list.stream().anyMatch(o -> o.getUsername().equals(name));
    }

    public boolean containsEmail(final List<User> list, final String email) {
        return list.stream().anyMatch(o -> o.getEmail().equals(email));
    }

    /**
     * saves a role
     *
     * @param role takes the role to save
     * @return returns the saved role
     */
    @Override
    public Role saveRol(Role role) {
        return userDAO.saveRoleToDatabase(role);
    }

    /**
     * adds a role to an user
     *
     * @param username takes the username
     * @param roleName takes the rolename
     */
    @Override
    public void addRolAanGebruiker(String username, String roleName) {
        User user = userRepository.findUserByUsername(username);
        Role role = rolRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    /**
     * Finds a single user
     *
     * @param username takes the name to find
     * @return returns the user
     */
    @Override
    public User getGebruiker(String username) {
        return userRepository.findUserByUsername(username);
    }

    /**
     * Finds all users
     *
     * @return returns a list of users
     */
    @Override
    public List<User> getGebruikers() {
        return userRepository.findAll();
    }

}
