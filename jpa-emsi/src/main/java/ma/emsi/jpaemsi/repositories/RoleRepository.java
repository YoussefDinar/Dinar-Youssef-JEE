package ma.emsi.jpaemsi.repositories;

import ma.emsi.jpaemsi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Indiquer que c'est un component pour la couche DAO
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}