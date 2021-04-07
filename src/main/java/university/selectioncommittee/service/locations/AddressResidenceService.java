package university.selectioncommittee.service.locations;

import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceCreateRequest;
import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceUpdateRequest;
import university.selectioncommittee.entity.locations.AddressResidence;

import java.util.List;

public interface AddressResidenceService {
    AddressResidence create(AddressResidenceCreateRequest request);
    AddressResidence put(Long id, AddressResidenceUpdateRequest request);
    AddressResidence retrieve(Long id);
    List<AddressResidence> list();
}
