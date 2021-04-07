package university.selectioncommittee.dto.enrolleeinfo.percs;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PercsResponse {

    private Long id;
    private boolean orphan;
    private boolean invalid;
    private boolean care;
    private boolean ethnicKyr;
}
