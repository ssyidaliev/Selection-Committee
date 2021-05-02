package university.selectioncommittee.endpoint.enrolleinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanResponse;
import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanUpdateRequest;
import university.selectioncommittee.endpoint.enrolleinfo.RecruitmentPlanEndpoint;
import university.selectioncommittee.entity.education.RecruitmentPlan;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.entity.subdivision.Faculty;
import university.selectioncommittee.entity.subdivision.Section;
import university.selectioncommittee.mapper.RecruitmentPlanMapper;
import university.selectioncommittee.service.enrolleeinfo.RecruitmentPlanService;
import university.selectioncommittee.service.subdivision.DirectionService;
import university.selectioncommittee.service.subdivision.FacultyService;
import university.selectioncommittee.service.subdivision.SectionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecruitmentPlanEndpointImpl implements RecruitmentPlanEndpoint {

    private final FacultyService facultyService;
    private final DirectionService directionService;
    private final SectionService sectionService;
    private final RecruitmentPlanService recruitmentPlanService;
    private final RecruitmentPlanMapper recruitmentPlanMapper;

    public RecruitmentPlanEndpointImpl(FacultyService facultyService, DirectionService directionService, SectionService sectionService, RecruitmentPlanService recruitmentPlanService, RecruitmentPlanMapper recruitmentPlanMapper) {
        this.facultyService = facultyService;
        this.directionService = directionService;
        this.sectionService = sectionService;
        this.recruitmentPlanService = recruitmentPlanService;
        this.recruitmentPlanMapper = recruitmentPlanMapper;
    }

    @Override
    @Transactional
    public RecruitmentPlanResponse add(RecruitmentPlanCreateRequest request) {
        Faculty faculty = null;
        Direction direction = null;
        Section section = null;
        if (request.getFacultyId() != null)
            faculty = facultyService.retrieve(request.getFacultyId());
        if (request.getDirectionId() != null)
            direction = directionService.retrieve(request.getDirectionId());
        if (request.getSectionId() != null)
            section = sectionService.retrieve(request.getSectionId());
        return recruitmentPlanMapper.toRecruitmentPlanResponse(recruitmentPlanService.create(request, faculty, direction, section));
    }

    @Override
    @Transactional
    public RecruitmentPlanResponse update(@NonNull Long id, RecruitmentPlanUpdateRequest request) {
        Faculty faculty = null;
        Direction direction = null;
        Section section = null;
        if (request.getFacultyId() != null)
            faculty = facultyService.retrieve(request.getFacultyId());
        if (request.getDirectionId() != null)
            direction = directionService.retrieve(request.getDirectionId());
        if (request.getSectionId() != null)
            section = sectionService.retrieve(request.getSectionId());
        return recruitmentPlanMapper.toRecruitmentPlanResponse(recruitmentPlanService.put(id, request, faculty, direction, section));
    }

    @Override
    @Transactional(readOnly = true)
    public RecruitmentPlanResponse getById(@NonNull Long id) {
        return recruitmentPlanMapper.toRecruitmentPlanResponse(recruitmentPlanService.retrieve(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecruitmentPlanResponse> getAll() {
        return recruitmentPlanService.list()
                .stream()
                .map(recruitmentPlanMapper::toRecruitmentPlanResponse)
                .collect(Collectors.toList());
    }
}
