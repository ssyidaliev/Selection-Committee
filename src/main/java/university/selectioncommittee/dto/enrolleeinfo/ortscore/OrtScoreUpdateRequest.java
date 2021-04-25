package university.selectioncommittee.dto.enrolleeinfo.ortscore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrtScoreUpdateRequest {
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
