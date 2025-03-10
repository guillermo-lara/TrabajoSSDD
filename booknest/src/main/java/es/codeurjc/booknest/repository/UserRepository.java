package es.codeurjc.booknest.repository;

import es.codeurjc.booknest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}