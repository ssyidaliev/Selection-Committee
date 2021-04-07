package university.selectioncommittee.endpoint.enrolleinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsResponse;
import university.selectioncommittee.dto.enrolleeinfo.percs.PercsUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.PercsEndpoint;
import university.selectioncommittee.mapper.PercsMapper;
import university.selectioncommittee.service.enrolleeinfo.PercsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PercsEndpointImpl implements PercsEndpoint {

    private final PercsService percsService;
    private final PercsMapper percsMapper;

    public PercsEndpointImpl(PercsService percsService, PercsMapper percsMapper) {
        this.percsService = percsService;
        this.percsMapper = percsMapper;
    }

    @Override
    @Transactional
    public PercsResponse add(@NonNull PercsCreateRequest request) {
        return percsMapper.toPercsResponse(percsService.create(request));
    }

    @Override
    @Transactional
    public PercsResponse update(@NonNull Long id, @NonNull PercsUpdateRequest request) {
        return percsMapper.toPercsResponse(percsService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public PercsResponse getById(@NonNull Long id) {
        return percsMapper.toPercsResponse(percsService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PercsResponse> getAll() {
        return percsService.list()
                .stream()
                .map(percsMapper::toPercsResponse)
                .collect(Collectors.toList());
    }
}
