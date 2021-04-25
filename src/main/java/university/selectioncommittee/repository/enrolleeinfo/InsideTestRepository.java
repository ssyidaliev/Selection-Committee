package university.selectioncommittee.repository.enrolleeinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.enrolleeinfo.InsideTest;

public interface InsideTestRepository extends JpaRepository<InsideTest, Long> {
}
