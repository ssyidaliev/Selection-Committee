package university.selectioncommittee.dto.enrolleeinfo.recruitmentplan;

import lombok.Builder;
import lombok.Getter;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.entity.subdivision.Faculty;
import university.selectioncommittee.entity.subdivision.Section;

@Getter
@Builder
public class RecruitmentPlanResponse {
    private Long id;
    private Faculty faculty;
    private Direction direction;
    private Section section;
    private String studyForm;
    private Integer docMoney;
    private Integer studyMoney;
    private String payType;
    private boolean reqTest;
}
