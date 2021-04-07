package university.selectioncommittee.endpoint.locations;

import university.selectioncommittee.dto.locations.addressbirth.AddressBirthCreateRequest;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthResponse;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthUpdateRequest;

import java.util.List;

public interface AddressBirthEndpoint {
    AddressBirthResponse add(AddressBirthCreateRequest request);
    AddressBirthResponse update(Long id, AddressBirthUpdateRequest request);
    AddressBirthResponse getById(Long id);
    List<AddressBirthResponse> getAll();
}
