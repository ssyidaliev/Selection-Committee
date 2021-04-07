package university.selectioncommittee.endpoint.locations.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.locations.addressparent.AddressParentCreateRequest;
import university.selectioncommittee.dto.locations.addressparent.AddressParentResponse;
import university.selectioncommittee.dto.locations.addressparent.AddressParentUpdateRequest;
import university.selectioncommittee.endpoint.locations.AddressParentEndpoint;
import university.selectioncommittee.mapper.AddressParentMapper;
import university.selectioncommittee.service.locations.AddressParentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressParentEndpointImpl implements AddressParentEndpoint {

    private final AddressParentService addressParentService;
    private final AddressParentMapper addressParentMapper;

    public AddressParentEndpointImpl(AddressParentService addressParentService, AddressParentMapper addressParentMapper) {
        this.addressParentService = addressParentService;
        this.addressParentMapper = addressParentMapper;
    }

    @Override
    @Transactional
    public AddressParentResponse add(@NonNull AddressParentCreateRequest request) {
        return addressParentMapper.toAddressParentResponse(addressParentService.create(request));
    }

    @Override
    @Transactional
    public AddressParentResponse update(@NonNull Long id, @NonNull AddressParentUpdateRequest request) {
        return addressParentMapper.toAddressParentResponse(addressParentService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public AddressParentResponse getById(@NonNull Long id) {
        return addressParentMapper.toAddressParentResponse(addressParentService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressParentResponse> getAll() {
        return addressParentService.list()
                .stream()
                .map(addressParentMapper::toAddressParentResponse)
                .collect(Collectors.toList());
    }
}
