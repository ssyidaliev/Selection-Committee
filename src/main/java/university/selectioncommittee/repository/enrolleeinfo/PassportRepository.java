package university.selectioncommittee.repository.enrolleeinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.enrolleeinfo.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {
}
