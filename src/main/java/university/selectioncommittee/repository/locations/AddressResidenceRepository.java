package university.selectioncommittee.repository.locations;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.locations.AddressResidence;

public interface AddressResidenceRepository extends JpaRepository<AddressResidence, Long> {
}
