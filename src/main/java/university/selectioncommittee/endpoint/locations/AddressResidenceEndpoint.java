package university.selectioncommittee.endpoint.locations;

import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceCreateRequest;
import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceResponse;
import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceUpdateRequest;

import java.util.List;

public interface AddressResidenceEndpoint {

    AddressResidenceResponse add(AddressResidenceCreateRequest request);
    AddressResidenceResponse update(Long id, AddressResidenceUpdateRequest request);
    AddressResidenceResponse getById(Long id);
    List<AddressResidenceResponse> getAll();
}

