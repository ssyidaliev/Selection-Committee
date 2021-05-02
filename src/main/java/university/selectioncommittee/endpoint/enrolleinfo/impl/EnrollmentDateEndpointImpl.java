package university.selectioncommittee.endpoint.enrolleinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateResponse;
import university.selectioncommittee.dto.enrolleeinfo.enrollmentdate.EnrollmentDateUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.EnrollmentDateEndpoint;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.mapper.EnrollmentDateMapper;
import university.selectioncommittee.service.enrolleeinfo.EnrollmentDateService;
import university.selectioncommittee.service.subdivision.DirectionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentDateEndpointImpl implements EnrollmentDateEndpoint {

    private final EnrollmentDateService enrollmentDateService;
    private final DirectionService directionService;
    private final EnrollmentDateMapper enrollmentDateMapper;

    public EnrollmentDateEndpointImpl(EnrollmentDateService enrollmentDateService, DirectionService directionService, EnrollmentDateMapper enrollmentDateMapper) {
        this.enrollmentDateService = enrollmentDateService;
        this.directionService = directionService;
        this.enrollmentDateMapper = enrollmentDateMapper;
    }

    @Override
    @Transactional
    public EnrollmentDateResponse add(EnrollmentDateCreateRequest request) {
        Direction direction = directionService.retrieve(request.getDirectionId());
        return enrollmentDateMapper.toEnrollmentDateResponse(enrollmentDateService.create(request, direction));
    }

    @Override
    @Transactional
    public EnrollmentDateResponse update(@NonNull Long id, EnrollmentDateUpdateRequest request) {
        Direction direction = directionService.retrieve(request.getDirectionId());
        return enrollmentDateMapper.toEnrollmentDateResponse(enrollmentDateService.put(id, request, direction));
    }

    @Override
    @Transactional(readOnly = true)
    public EnrollmentDateResponse getById(@NonNull Long id) {
        return enrollmentDateMapper.toEnrollmentDateResponse(enrollmentDateService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EnrollmentDateResponse> getAll() {
        return enrollmentDateService.list()
                .stream()
                .map(enrollmentDateMapper::toEnrollmentDateResponse)
                .collect(Collectors.toList());
    }
}
