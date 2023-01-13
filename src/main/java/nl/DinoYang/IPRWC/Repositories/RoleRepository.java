package nl.DinoYang.IPRWC.Repositories;

import nl.DinoYang.IPRWC.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface RoleRepository extends JpaRepository<Role, Long> {
        Role findByName(String name);
    }
