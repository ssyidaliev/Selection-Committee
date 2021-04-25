package university.selectioncommittee.dto.enrolleeinfo.insidetest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsideTestUpdateRequest {
    private Long id;
    private boolean passedByOrtResult;
    private Integer reqScore;
    private Integer placeNum;
    private Integer placeCount;
}
