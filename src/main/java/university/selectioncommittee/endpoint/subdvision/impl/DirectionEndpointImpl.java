package university.selectioncommittee.endpoint.subdvision.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.subdivision.direction.DirectionCreateRequest;
import university.selectioncommittee.dto.subdivision.direction.DirectionResponse;
import university.selectioncommittee.dto.subdivision.direction.DirectionUpdateRequest;
import university.selectioncommittee.endpoint.subdvision.DirectionEndpoint;
import university.selectioncommittee.entity.subdivision.Faculty;
import university.selectioncommittee.mapper.DirectionMapper;
import university.selectioncommittee.service.subdivision.DirectionService;
import university.selectioncommittee.service.subdivision.FacultyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectionEndpointImpl implements DirectionEndpoint {

    private final DirectionService directionService;
    private final FacultyService facultyService;
    private final DirectionMapper directionMapper;

    public DirectionEndpointImpl(DirectionService directionService, FacultyService facultyService, DirectionMapper directionMapper) {
        this.directionService = directionService;
        this.facultyService = facultyService;
        this.directionMapper = directionMapper;
    }

    @Override
    @Transactional
    public DirectionResponse add(@NonNull DirectionCreateRequest request) {
        Faculty faculty = facultyService.retrieve(request.getFacultyId());
        return directionMapper.toDirectionResponse(directionService.create(request, faculty));
    }

    @Override
    @Transactional
    public DirectionResponse update(@NonNull Long id, @NonNull DirectionUpdateRequest request) {
        Faculty faculty = facultyService.retrieve(request.getFacultyId());
        return directionMapper.toDirectionResponse(directionService.put(id, request, faculty));
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

    @Override
    @Transactional(readOnly = true)
    public List<DirectionResponse> getAllByFaculty(@NonNull Long facultyId) {
        return directionService.listByFaculty(facultyId)
                .stream()
                .map(directionMapper::toDirectionResponse)
                .collect(Collectors.toList());
    }
}
