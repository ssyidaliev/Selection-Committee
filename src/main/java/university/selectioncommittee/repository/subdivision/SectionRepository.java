package university.selectioncommittee.repository.subdivision;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.subdivision.Section;

public interface SectionRepository extends JpaRepository<Section, Long>{
}
