package university.selectioncommittee.dto.enrolleeinfo.percs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PercsCreateRequest {

    private boolean orphan;
    private boolean invalid;
    private boolean care;
    private boolean ethnicKyr;
}
