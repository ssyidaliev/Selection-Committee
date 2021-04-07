package university.selectioncommittee.repository.locations;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.locations.AddressParent;

public interface AddressParentRepository extends JpaRepository<AddressParent, Long> {
}
