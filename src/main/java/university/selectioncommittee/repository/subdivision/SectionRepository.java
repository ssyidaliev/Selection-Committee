package university.selectioncommittee.repository.subdivision;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.entity.subdivision.Section;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Long> {
    List<Section> findAllByDirectionId(Long directionId);
}
