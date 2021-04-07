package university.selectioncommittee.repository.locations;

import org.springframework.data.jpa.repository.JpaRepository;
import university.selectioncommittee.entity.locations.AddressLiving;

public interface AddressLivingRepository extends JpaRepository<AddressLiving, Long> {
}
