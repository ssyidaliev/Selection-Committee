package university.selectioncommittee.repository.subdivision;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.subdivision.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{
}
