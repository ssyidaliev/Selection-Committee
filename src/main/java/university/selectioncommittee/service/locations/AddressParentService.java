package university.selectioncommittee.service.locations;

import university.selectioncommittee.dto.locations.addressparent.AddressParentCreateRequest;
import university.selectioncommittee.dto.locations.addressparent.AddressParentUpdateRequest;
import university.selectioncommittee.entity.locations.AddressParent;

import java.util.List;

public interface AddressParentService {
    AddressParent create(AddressParentCreateRequest request);
    AddressParent put(Long id, AddressParentUpdateRequest request);
    AddressParent retrieve(Long id);
    List<AddressParent> list();
}
