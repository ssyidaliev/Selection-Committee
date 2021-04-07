package university.selectioncommittee.endpoint.locations.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.locations.addressliving.AddressLivingCreateRequest;
import university.selectioncommittee.dto.locations.addressliving.AddressLivingResponse;
import university.selectioncommittee.dto.locations.addressliving.AddressLivingUpdateRequest;
import university.selectioncommittee.endpoint.locations.AddressLivingEndpoint;
import university.selectioncommittee.mapper.AddressLivingMapper;
import university.selectioncommittee.service.locations.AddressLivingService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressLivingEndpointImpl implements AddressLivingEndpoint {

    private final AddressLivingService addressLivingService;
    private final AddressLivingMapper addressLivingMapper;

    public AddressLivingEndpointImpl(AddressLivingService addressLivingService, AddressLivingMapper addressLivingMapper) {
        this.addressLivingService = addressLivingService;
        this.addressLivingMapper = addressLivingMapper;
    }

    @Override
    @Transactional
    public AddressLivingResponse add(@NonNull AddressLivingCreateRequest request) {
        return addressLivingMapper.toAddressLivingResponse(addressLivingService.create(request));
    }

    @Override
    @Transactional
    public AddressLivingResponse update(@NonNull Long id, @NonNull AddressLivingUpdateRequest request) {
        return addressLivingMapper.toAddressLivingResponse(addressLivingService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public AddressLivingResponse getById(@NonNull Long id) {
        return addressLivingMapper.toAddressLivingResponse(addressLivingService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressLivingResponse> getAll() {
        return addressLivingService.list()
                .stream()
                .map(addressLivingMapper::toAddressLivingResponse)
                .collect(Collectors.toList());
    }
}
