package tst.sem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tst.sem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String username);


}
