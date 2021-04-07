package university.selectioncommittee.service.locations;

import university.selectioncommittee.dto.locations.addressbirth.AddressBirthCreateRequest;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthUpdateRequest;
import university.selectioncommittee.entity.locations.AddressBirth;

import java.util.List;

public interface AddressBirthService {
    AddressBirth create(AddressBirthCreateRequest request);
    AddressBirth put(Long id, AddressBirthUpdateRequest request);
    AddressBirth retrieve(Long id);
    List<AddressBirth> list();
}
