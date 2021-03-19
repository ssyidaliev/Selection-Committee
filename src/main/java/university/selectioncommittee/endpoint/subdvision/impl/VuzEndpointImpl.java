package university.selectioncommittee.endpoint.subdvision.impl;

import lombok.NonNull;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.subdivision.vuz.VuzCreateRequest;
import university.selectioncommittee.dto.subdivision.vuz.VuzResponse;
import university.selectioncommittee.dto.subdivision.vuz.VuzUpdateRequest;
import university.selectioncommittee.endpoint.subdvision.VuzEndpoint;
import university.selectioncommittee.mapper.VuzMapper;
import university.selectioncommittee.service.subdivision.VuzService;

import java.util.List;
import java.util.stream.Collectors;

public class VuzEndpointImpl implements VuzEndpoint {

    private final VuzService vuzService;
    private final VuzMapper vuzMapper;

    public VuzEndpointImpl(VuzService vuzService, VuzMapper vuzMapper) {
        this.vuzService = vuzService;
        this.vuzMapper = vuzMapper;
    }

    @Override
    @Transactional
    public VuzResponse add(@NonNull VuzCreateRequest request) {
        return vuzMapper.toVuzResponse(vuzService.create(request));
    }

    @Override
    @Transactional
    public VuzResponse update(@NonNull Long id, @NonNull VuzUpdateRequest request) {
        return vuzMapper.toVuzResponse(vuzService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public VuzResponse getById(@NonNull Long id) {
        return vuzMapper.toVuzResponse(vuzService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<VuzResponse> getAll() {
        return vuzService.list()
                .stream()
                .map(vuzMapper::toVuzResponse)
                .collect(Collectors.toList());
    }
}
