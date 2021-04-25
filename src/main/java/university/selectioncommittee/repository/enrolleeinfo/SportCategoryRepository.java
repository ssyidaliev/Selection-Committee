package university.selectioncommittee.repository.enrolleeinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.enrolleeinfo.SportCategory;

public interface SportCategoryRepository extends JpaRepository<SportCategory, Long> {
}
