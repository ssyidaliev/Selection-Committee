package university.selectioncommittee.endpoint.subdvision.impl;

import lombok.NonNull;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.subdivision.direction.DirectionCreateRequest;
import university.selectioncommittee.dto.subdivision.direction.DirectionResponse;
import university.selectioncommittee.dto.subdivision.direction.DirectionUpdateRequest;
import university.selectioncommittee.endpoint.subdvision.DirectionEndpoint;
import university.selectioncommittee.mapper.DirectionMapper;
import university.selectioncommittee.service.subdivision.DirectionService;

import java.util.List;
import java.util.stream.Collectors;

public class DirectionEndpointImpl implements DirectionEndpoint {

    private final DirectionService directionService;
    private final DirectionMapper directionMapper;

    public DirectionEndpointImpl(DirectionService directionService, DirectionMapper directionMapper) {
        this.directionService = directionService;
        this.directionMapper = directionMapper;
    }

    @Override
    @Transactional
    public DirectionResponse add(@NonNull DirectionCreateRequest request) {
        return directionMapper.toDirectionResponse(directionService.create(request));
    }

    @Override
    @Transactional
    public DirectionResponse update(@NonNull Long id, @NonNull DirectionUpdateRequest request) {
        return directionMapper.toDirectionResponse(directionService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public DirectionResponse getById(@NonNull Long id) {
        return directionMapper.toDirectionResponse(directionService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DirectionResponse> getAll() {
        return directionService.list()
                .stream()
                .map(directionMapper::toDirectionResponse)
                .collect(Collectors.toList());
    }
}
