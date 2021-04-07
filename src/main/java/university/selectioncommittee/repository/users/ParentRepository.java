package university.selectioncommittee.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.users.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
