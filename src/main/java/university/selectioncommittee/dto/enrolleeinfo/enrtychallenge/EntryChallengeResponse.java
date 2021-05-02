package university.selectioncommittee.dto.enrolleeinfo.enrtychallenge;

import lombok.Builder;
import lombok.Getter;
import university.selectioncommittee.entity.enrolleeinfo.InsideTest;
import university.selectioncommittee.entity.enrolleeinfo.OrtScore;

@Getter
@Builder
public class EntryChallengeResponse {

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
    private InsideTest insideTest;
    private OrtScore ortScore;
}
