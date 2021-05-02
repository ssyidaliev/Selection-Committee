package university.selectioncommittee.endpoint.users.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.users.parent.ParentCreateRequest;
import university.selectioncommittee.dto.users.parent.ParentResponse;
import university.selectioncommittee.dto.users.parent.ParentUpdateRequest;
import university.selectioncommittee.endpoint.users.ParentEndpoint;
import university.selectioncommittee.entity.locations.AddressParent;
import university.selectioncommittee.mapper.ParentMapper;
import university.selectioncommittee.service.locations.AddressParentService;
import university.selectioncommittee.service.users.ParentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentEndpointImpl implements ParentEndpoint {

    private final ParentMapper parentMapper;
    private final ParentService parentService;
    private final AddressParentService addressParentService;

    public ParentEndpointImpl(ParentMapper parentMapper, ParentService parentService, AddressParentService addressParentService) {
        this.parentMapper = parentMapper;
        this.parentService = parentService;
        this.addressParentService = addressParentService;
    }

    @Override
    @Transactional
    public ParentResponse add(@NonNull ParentCreateRequest request) {
        AddressParent addressParent =  addressParentService.retrieve(request.getAddressParentId());
        return parentMapper.toParentResponse(parentService.create(request, addressParent));
    }

    @Override
    @Transactional
    public ParentResponse update(@NonNull Long id, @NonNull ParentUpdateRequest request) {
        AddressParent addressParent =  addressParentService.retrieve(request.getAddressParentId());
        return parentMapper.toParentResponse(parentService.put(id, request, addressParent));
    }

    @Override
    @Transactional
    public ParentResponse getById(@NonNull Long id) {
        return parentMapper.toParentResponse(parentService.retrieve(id));
    }

    @Override
    @Transactional
    public List<ParentResponse> getAll() {
        return parentService.list()
                .stream()
                .map(parentMapper::toParentResponse)
                .collect(Collectors.toList());
    }
}
