package university.selectioncommittee.endpoint.locations;

import university.selectioncommittee.dto.locations.addressparent.AddressParentCreateRequest;
import university.selectioncommittee.dto.locations.addressparent.AddressParentResponse;
import university.selectioncommittee.dto.locations.addressparent.AddressParentUpdateRequest;

import java.util.List;

public interface AddressParentEndpoint {
    AddressParentResponse add(AddressParentCreateRequest request);
    AddressParentResponse update(Long id, AddressParentUpdateRequest request);
    AddressParentResponse getById(Long id);
    List<AddressParentResponse> getAll();
}
