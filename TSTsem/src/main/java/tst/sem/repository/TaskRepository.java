package tst.sem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tst.sem.entity.Task;

import java.util.List;

/**
 * Created by Michal on 27.03.2017.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUserName(String username);
}
