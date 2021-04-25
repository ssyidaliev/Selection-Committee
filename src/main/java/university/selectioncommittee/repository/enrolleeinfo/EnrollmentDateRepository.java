package university.selectioncommittee.repository.enrolleeinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.enrolleeinfo.EnrollmentDate;

public interface EnrollmentDateRepository extends JpaRepository<EnrollmentDate, Long> {
}
