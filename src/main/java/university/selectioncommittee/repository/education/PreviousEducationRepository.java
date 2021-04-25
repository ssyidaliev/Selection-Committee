package university.selectioncommittee.repository.education;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.education.PreviousEducation;

public interface PreviousEducationRepository extends JpaRepository<PreviousEducation, Long> {
}
