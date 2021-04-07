package university.selectioncommittee.endpoint.locations;

import university.selectioncommittee.dto.locations.addressliving.AddressLivingCreateRequest;
import university.selectioncommittee.dto.locations.addressliving.AddressLivingResponse;
import university.selectioncommittee.dto.locations.addressliving.AddressLivingUpdateRequest;

import java.util.List;

public interface AddressLivingEndpoint {
    AddressLivingResponse add(AddressLivingCreateRequest request);
    AddressLivingResponse update(Long id, AddressLivingUpdateRequest request);
    AddressLivingResponse getById(Long id);
    List<AddressLivingResponse> getAll();
}
