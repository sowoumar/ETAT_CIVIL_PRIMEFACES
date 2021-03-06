package org.etatcivil.repository;

import org.etatcivil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByName(String name);

    User findByFirstnameAndName(String firstname, String name);

    Long countUsersByFirstnameAndName(String firstname, String name);
}
