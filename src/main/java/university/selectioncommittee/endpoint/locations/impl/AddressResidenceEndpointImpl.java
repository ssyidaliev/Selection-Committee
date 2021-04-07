package university.selectioncommittee.endpoint.locations.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceCreateRequest;
import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceResponse;
import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceUpdateRequest;
import university.selectioncommittee.endpoint.locations.AddressResidenceEndpoint;
import university.selectioncommittee.mapper.AddressResidenceMapper;
import university.selectioncommittee.service.locations.AddressResidenceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressResidenceEndpointImpl implements AddressResidenceEndpoint {

    private final AddressResidenceService addressResidenceService;
    private final AddressResidenceMapper addressResidenceMapper;

    public AddressResidenceEndpointImpl(AddressResidenceService addressResidenceService, AddressResidenceMapper addressResidenceMapper) {
        this.addressResidenceService = addressResidenceService;
        this.addressResidenceMapper = addressResidenceMapper;
    }

    @Override
    @Transactional
    public AddressResidenceResponse add(@NonNull AddressResidenceCreateRequest request) {
        return addressResidenceMapper.toAddressResidenceResponse(addressResidenceService.create(request));
    }

    @Override
    @Transactional
    public AddressResidenceResponse update(@NonNull Long id, @NonNull AddressResidenceUpdateRequest request) {
        return addressResidenceMapper.toAddressResidenceResponse(addressResidenceService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public AddressResidenceResponse getById(@NonNull Long id) {
        return addressResidenceMapper.toAddressResidenceResponse(addressResidenceService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressResidenceResponse> getAll() {
        return addressResidenceService.list()
                .stream()
                .map(addressResidenceMapper::toAddressResidenceResponse)
                .collect(Collectors.toList());
    }
}
