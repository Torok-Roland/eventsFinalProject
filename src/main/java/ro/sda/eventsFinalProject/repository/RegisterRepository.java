package ro.sda.eventsFinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.eventsFinalProject.model.Register;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {
    Register findByUserName(String userName);

//    Optional<Register> findByUserNameAndPassword(String userName, String password);
}
