package university.selectioncommittee.service.enrolleeinfo.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanUpdateRequest;
import university.selectioncommittee.entity.education.RecruitmentPlan;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.entity.subdivision.Faculty;
import university.selectioncommittee.entity.subdivision.Section;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.enrolleeinfo.RecruitmentPlanRepository;
import university.selectioncommittee.service.enrolleeinfo.RecruitmentPlanService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecruitmentPlanServiceImpl implements RecruitmentPlanService {

    private final RecruitmentPlanRepository recruitmentPlanRepository;

    public RecruitmentPlanServiceImpl(RecruitmentPlanRepository recruitmentPlanRepository) {
        this.recruitmentPlanRepository = recruitmentPlanRepository;
    }

    @Override
    @Transactional
    public RecruitmentPlan create(RecruitmentPlanCreateRequest request, Faculty faculty, Direction direction, Section section) {
        RecruitmentPlan recruitmentPlan = new RecruitmentPlan();
        recruitmentPlan.setFaculty(faculty);
        recruitmentPlan.setDirection(direction);
        recruitmentPlan.setSection(section);
        recruitmentPlan.setStudyForm(request.getStudyForm());
        recruitmentPlan.setDocMoney(request.getDocMoney());
        recruitmentPlan.setStudyMoney(request.getStudyMoney());
        recruitmentPlan.setPayType(request.getPayType());
        recruitmentPlan.setReqTest(request.isReqTest());
        recruitmentPlan.setCreateAt(LocalDateTime.now());
        return recruitmentPlanRepository.save(recruitmentPlan);
    }

    @Override
    @Transactional
    public RecruitmentPlan put(@NonNull Long id, RecruitmentPlanUpdateRequest request, Faculty faculty, Direction direction, Section section) {
        RecruitmentPlan recruitmentPlan = retrieve(id);
        recruitmentPlan.setFaculty(faculty);
        recruitmentPlan.setDirection(direction);
        recruitmentPlan.setSection(section);
        recruitmentPlan.setStudyForm(request.getStudyForm());
        recruitmentPlan.setDocMoney(request.getDocMoney());
        recruitmentPlan.setStudyMoney(request.getStudyMoney());
        recruitmentPlan.setPayType(request.getPayType());
        recruitmentPlan.setReqTest(request.isReqTest());
        recruitmentPlan.setUpdateAt(LocalDateTime.now());
        return recruitmentPlanRepository.save(recruitmentPlan);
    }

    @Override
    @Transactional(readOnly = true)
    public RecruitmentPlan retrieve(@NonNull Long id) {
        return recruitmentPlanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Recruitment Plan with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecruitmentPlan> list() {
        return recruitmentPlanRepository.findAll();
    }
}
