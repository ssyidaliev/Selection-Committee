package university.selectioncommittee.dto.enrolleeinfo.insidetest;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InsideTestResponse {

    private Long id;
    private boolean passedByOrtResult;
    private Integer reqScore;
    private Integer placeNum;
    private Integer placeCount;
}
