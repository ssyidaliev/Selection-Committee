package university.selectioncommittee.dto.enrolleeinfo.enrtychallenge;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EntryChallengeUpdateRequest {
    private Long id;
    private boolean passedOrt;
    private String certificateNum;
    private String certificateColor;
    private String sumScore;
    private String tourNum;
    private boolean afterCollage;
    private boolean dontAppear;
    private boolean noSatisfied;
    private boolean passedInsideTest;
    private Long insideTestId;
    private Long ortScoreId;
}
