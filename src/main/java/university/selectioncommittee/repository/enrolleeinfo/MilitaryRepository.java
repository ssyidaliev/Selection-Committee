package university.selectioncommittee.repository.enrolleeinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.enrolleeinfo.Military;

public interface MilitaryRepository extends JpaRepository<Military, Long> {
}
