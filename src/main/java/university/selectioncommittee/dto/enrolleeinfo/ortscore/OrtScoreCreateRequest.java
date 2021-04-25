package university.selectioncommittee.dto.enrolleeinfo.ortscore;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class OrtScoreCreateRequest {
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
