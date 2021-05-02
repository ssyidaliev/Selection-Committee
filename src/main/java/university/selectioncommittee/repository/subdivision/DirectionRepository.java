package university.selectioncommittee.repository.subdivision;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.subdivision.Direction;

import java.util.List;

public interface DirectionRepository extends JpaRepository<Direction, Long> {
    List<Direction> findAllByFacultyId(Long facultyId);
}
