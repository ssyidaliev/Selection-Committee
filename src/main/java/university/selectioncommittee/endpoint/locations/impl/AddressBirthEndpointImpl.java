package university.selectioncommittee.endpoint.locations.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthCreateRequest;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthResponse;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthUpdateRequest;
import university.selectioncommittee.endpoint.locations.AddressBirthEndpoint;
import university.selectioncommittee.mapper.AddressBirthMapper;
import university.selectioncommittee.service.locations.AddressBirthService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBirthEndpointImpl implements AddressBirthEndpoint {

    private final AddressBirthMapper addressBirthMapper;
    private final AddressBirthService addressBirthService;

    public AddressBirthEndpointImpl(AddressBirthMapper addressBirthMapper, AddressBirthService addressBirthService) {
        this.addressBirthMapper = addressBirthMapper;
        this.addressBirthService = addressBirthService;
    }

    @Override
    @Transactional
    public AddressBirthResponse add(@NonNull AddressBirthCreateRequest request) {
        return addressBirthMapper.toAddressBirthResponse(addressBirthService.create(request));
    }

    @Override
    @Transactional
    public AddressBirthResponse update(@NonNull Long id, @NonNull AddressBirthUpdateRequest request) {
        return addressBirthMapper.toAddressBirthResponse(addressBirthService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public AddressBirthResponse getById(@NonNull Long id) {
        return addressBirthMapper.toAddressBirthResponse(addressBirthService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressBirthResponse> getAll() {
        return addressBirthService.list()
                .stream()
                .map(addressBirthMapper::toAddressBirthResponse)
                .collect(Collectors.toList());
    }
}
