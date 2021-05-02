package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.enrolleeinfo.recruitmentplan.RecruitmentPlanResponse;
import university.selectioncommittee.entity.education.RecruitmentPlan;

@Component
public class RecruitmentPlanMapper {

    public RecruitmentPlanResponse toRecruitmentPlanResponse(@NonNull RecruitmentPlan recruitmentPlan) {
        return RecruitmentPlanResponse.builder()
                .id(recruitmentPlan.getId())
                .faculty(recruitmentPlan.getFaculty())
                .direction(recruitmentPlan.getDirection())
                .section(recruitmentPlan.getSection())
                .studyForm(recruitmentPlan.getStudyForm())
                .studyMoney(recruitmentPlan.getStudyMoney())
                .payType(recruitmentPlan.getPayType())
                .reqTest(recruitmentPlan.isReqTest())
                .build();
    }
}
