package university.selectioncommittee.repository.subdivision;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.subdivision.Direction;

public interface DirectionRepository extends JpaRepository<Direction, Long> {
}
