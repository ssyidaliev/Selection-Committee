package university.selectioncommittee.repository.locations;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.locations.AddressBirth;

public interface AddressBirthRepository extends JpaRepository<AddressBirth, Long> {
}
