package university.selectioncommittee.endpoint.education.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.education.education.EducationCreateRequest;
import university.selectioncommittee.dto.education.education.EducationResponse;
import university.selectioncommittee.dto.education.education.EducationUpdateRequest;
import university.selectioncommittee.endpoint.education.EducationEndpoint;
import university.selectioncommittee.entity.education.EducationalInstitution;
import university.selectioncommittee.entity.enrolleeinfo.SportCategory;
import university.selectioncommittee.mapper.EducationMapper;
import university.selectioncommittee.service.education.EducationService;
import university.selectioncommittee.service.education.EducationalInstitutionService;
import university.selectioncommittee.service.enrolleeinfo.SportCategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationEndpointImpl implements EducationEndpoint {

    private final EducationMapper educationMapper;
    private final EducationService educationService;
    private final SportCategoryService sportCategoryService;
    private final EducationalInstitutionService educationalInstitutionService;

    public EducationEndpointImpl(EducationMapper educationMapper, EducationService educationService, SportCategoryService sportCategoryService, EducationalInstitutionService educationalInstitutionService) {
        this.educationMapper = educationMapper;
        this.educationService = educationService;
        this.sportCategoryService = sportCategoryService;
        this.educationalInstitutionService = educationalInstitutionService;
    }

    @Override
    @Transactional
    public EducationResponse add(EducationCreateRequest request) {
        SportCategory sportCategory = null;
        EducationalInstitution educationalInstitution = null;
        if (request.getSportCategoryId() != null)
            sportCategory = sportCategoryService.retrieve(request.getSportCategoryId());
        if (request.getEducationalInstitutionId() != null)
            educationalInstitution = educationalInstitutionService.retrieve(request.getEducationalInstitutionId());
        return educationMapper.toEducationResponse(educationService.create(request, sportCategory, educationalInstitution));
    }

    @Override
    @Transactional
    public EducationResponse update(@NonNull Long id, EducationUpdateRequest request) {
        SportCategory sportCategory = null;
        EducationalInstitution educationalInstitution = null;
        if (request.getSportCategoryId() != null)
            sportCategory = sportCategoryService.retrieve(request.getSportCategoryId());
        if (request.getEducationalInstitutionId() != null)
            educationalInstitution = educationalInstitutionService.retrieve(request.getEducationalInstitutionId());
        return educationMapper.toEducationResponse(educationService.put(id, request, sportCategory, educationalInstitution));
    }

    @Override
    @Transactional(readOnly = true)
    public EducationResponse getById(@NonNull Long id) {
        return educationMapper.toEducationResponse(educationService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EducationResponse> getAll() {
        return educationService.list()
                .stream()
                .map(educationMapper::toEducationResponse)
                .collect(Collectors.toList());
    }
}
