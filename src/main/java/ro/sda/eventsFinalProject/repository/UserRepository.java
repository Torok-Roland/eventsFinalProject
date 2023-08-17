package ro.sda.eventsFinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.eventsFinalProject.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
}
