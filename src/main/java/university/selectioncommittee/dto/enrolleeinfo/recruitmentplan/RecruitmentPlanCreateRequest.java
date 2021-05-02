package university.selectioncommittee.dto.enrolleeinfo.recruitmentplan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecruitmentPlanCreateRequest {

    private Long facultyId;
    private Long directionId;
    private Long sectionId;
    private String studyForm;
    private Integer docMoney;
    private Integer studyMoney;
    private String payType;
    private boolean reqTest;
}
