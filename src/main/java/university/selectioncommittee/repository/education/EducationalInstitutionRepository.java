package university.selectioncommittee.repository.education;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.education.EducationalInstitution;

public interface EducationalInstitutionRepository extends JpaRepository<EducationalInstitution, Long> {
}
