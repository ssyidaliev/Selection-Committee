package university.selectioncommittee.endpoint.enrolleinfo;

import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanCreateRequest;
import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanResponse;
import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanUpdateRequest;

import java.util.List;

public interface RecruitmentPlanEndpoint {
    RecruitmentPlanResponse add(RecruitmentPlanCreateRequest request);
    RecruitmentPlanResponse update(Long id, RecruitmentPlanUpdateRequest request);
    RecruitmentPlanResponse getById(Long id);
    List<RecruitmentPlanResponse> getAll();
}
