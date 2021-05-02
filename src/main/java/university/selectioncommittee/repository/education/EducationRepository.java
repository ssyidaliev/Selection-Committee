package university.selectioncommittee.repository.education;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.education.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
