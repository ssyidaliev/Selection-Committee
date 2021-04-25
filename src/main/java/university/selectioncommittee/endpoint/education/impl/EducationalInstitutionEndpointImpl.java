package university.selectioncommittee.endpoint.education.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionCreateRequest;
import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionResponse;
import university.selectioncommittee.dto.education.educationalinstitution.EducationalInstitutionUpdateRequest;
import university.selectioncommittee.endpoint.education.EducationalInstitutionEndpoint;
import university.selectioncommittee.entity.education.PreviousEducation;
import university.selectioncommittee.mapper.EducationalInstitutionMapper;
import university.selectioncommittee.service.education.EducationalInstitutionService;
import university.selectioncommittee.service.education.PreviousEducationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationalInstitutionEndpointImpl implements EducationalInstitutionEndpoint {

    private final EducationalInstitutionService educationalInstitutionService;
    private final EducationalInstitutionMapper educationalInstitutionMapper;
    private final PreviousEducationService previousEducationService;

    public EducationalInstitutionEndpointImpl(EducationalInstitutionService educationalInstitutionService, EducationalInstitutionMapper educationalInstitutionMapper, PreviousEducationService previousEducationService) {
        this.educationalInstitutionService = educationalInstitutionService;
        this.educationalInstitutionMapper = educationalInstitutionMapper;
        this.previousEducationService = previousEducationService;
    }

    @Override
    @Transactional
    public EducationalInstitutionResponse add(@NonNull EducationalInstitutionCreateRequest request) {
        PreviousEducation previousEducation = previousEducationService.retrieve(request.getPreviousEducationId());
        return educationalInstitutionMapper.toEducationalInstitutionResponse(educationalInstitutionService.create(request, previousEducation));
    }

    @Override
    @Transactional
    public EducationalInstitutionResponse update(@NonNull Long id, @NonNull EducationalInstitutionUpdateRequest request) {
        PreviousEducation previousEducation = previousEducationService.retrieve(request.getPreviousEducationId());
        return educationalInstitutionMapper.toEducationalInstitutionResponse(educationalInstitutionService.put(id, request, previousEducation));
    }

    @Override
    @Transactional(readOnly = true)
    public EducationalInstitutionResponse getById(@NonNull Long id) {
        return educationalInstitutionMapper.toEducationalInstitutionResponse(educationalInstitutionService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EducationalInstitutionResponse> getAll() {
        return educationalInstitutionService.list()
                .stream()
                .map(educationalInstitutionMapper::toEducationalInstitutionResponse)
                .collect(Collectors.toList());
    }
}
