package university.selectioncommittee.endpoint.subdvision.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.subdivision.faculty.FacultyCreateRequest;
import university.selectioncommittee.dto.subdivision.faculty.FacultyResponse;
import university.selectioncommittee.dto.subdivision.faculty.FacultyUpdateRequest;
import university.selectioncommittee.endpoint.subdvision.FacultyEndpoint;
import university.selectioncommittee.entity.subdivision.VUZ;
import university.selectioncommittee.mapper.FacultyMapper;
import university.selectioncommittee.service.subdivision.FacultyService;
import university.selectioncommittee.service.subdivision.VuzService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyEndpointImpl implements FacultyEndpoint {

    private final FacultyService facultyService;
    private final FacultyMapper facultyMapper;
    private final VuzService vuzService;

    public FacultyEndpointImpl(FacultyService facultyService, FacultyMapper facultyMapper, VuzService vuzService) {
        this.facultyService = facultyService;
        this.facultyMapper = facultyMapper;
        this.vuzService = vuzService;
    }

    @Override
    @Transactional
    public FacultyResponse add(@NonNull FacultyCreateRequest request) {
        VUZ vuz = vuzService.retrieve(request.getVuzId());
        return facultyMapper.toFacultyResponse(facultyService.create(request, vuz));
    }

    @Override
    @Transactional
    public FacultyResponse update(@NonNull Long id, @NonNull FacultyUpdateRequest request) {
        VUZ vuz = vuzService.retrieve(request.getVuzId());
        return facultyMapper.toFacultyResponse(facultyService.put(id, request, vuz));
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
