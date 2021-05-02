package university.selectioncommittee.service.enrolleeinfo;

import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanUpdateRequest;
import university.selectioncommittee.entity.education.RecruitmentPlan;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.entity.subdivision.Faculty;
import university.selectioncommittee.entity.subdivision.Section;

import java.util.List;

public interface RecruitmentPlanService {
    RecruitmentPlan create(RecruitmentPlanCreateRequest request, Faculty faculty, Direction direction, Section section);
    RecruitmentPlan put(Long id, RecruitmentPlanUpdateRequest request, Faculty faculty, Direction direction, Section section);
    RecruitmentPlan retrieve(Long id);
    List<RecruitmentPlan> list();
}
