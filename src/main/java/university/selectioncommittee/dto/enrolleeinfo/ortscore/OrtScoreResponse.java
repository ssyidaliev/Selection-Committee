package university.selectioncommittee.dto.enrolleeinfo.ortscore;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrtScoreResponse {
    private Long id;
    private Integer basicScore;
    private Integer kyrSubScore;
    private Integer bioSubScore;
    private Integer phySubScore;
    private Integer chemSubScore;
    private Integer mathSubScore;
    private Integer hisSubScore;
    private Integer engSubScore;
    private Integer rusSubScore;
}
