package repositories;

import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository lives as singleton in the container, therefore our Repositories life cycle is singleton
public interface UserRepository extends JpaRepository<User, Long> {
}
