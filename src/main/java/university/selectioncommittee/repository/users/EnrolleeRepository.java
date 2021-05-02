package university.selectioncommittee.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.users.Enrollee;

public interface EnrolleeRepository extends JpaRepository<Enrollee, Long> {
}
