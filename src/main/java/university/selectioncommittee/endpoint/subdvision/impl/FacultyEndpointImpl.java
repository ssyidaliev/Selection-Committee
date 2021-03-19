package university.selectioncommittee.endpoint.subdvision.impl;

import lombok.NonNull;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.subdivision.faculty.FacultyCreateRequest;
import university.selectioncommittee.dto.subdivision.faculty.FacultyResponse;
import university.selectioncommittee.dto.subdivision.faculty.FacultyUpdateRequest;
import university.selectioncommittee.endpoint.subdvision.FacultyEndpoint;
import university.selectioncommittee.mapper.FacultyMapper;
import university.selectioncommittee.service.subdivision.FacultyService;

import java.util.List;
import java.util.stream.Collectors;

public class FacultyEndpointImpl implements FacultyEndpoint {

    private final FacultyService facultyService;
    private final FacultyMapper facultyMapper;

    public FacultyEndpointImpl(FacultyService facultyService, FacultyMapper facultyMapper) {
        this.facultyService = facultyService;
        this.facultyMapper = facultyMapper;
    }

    @Override
    @Transactional
    public FacultyResponse add(@NonNull FacultyCreateRequest request) {
        return facultyMapper.toFacultyResponse(facultyService.create(request));
    }

    @Override
    @Transactional
    public FacultyResponse update(@NonNull Long id, @NonNull FacultyUpdateRequest request) {
        return facultyMapper.toFacultyResponse(facultyService.put(id, request));
    }

    @Override
    @Transactional(readOnly = true)
    public FacultyResponse getById(@NonNull Long id) {
        return facultyMapper.toFacultyResponse(facultyService.retrieve(id));
    }

    @Override
    public List<FacultyResponse> getAll() {
        return facultyService.list()
                .stream()
                .map(facultyMapper::toFacultyResponse)
                .collect(Collectors.toList());
    }
}
