package university.selectioncommittee.dto.enrolleeinfo.percs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PercsUpdateRequest {

    private Long id;
    private boolean orphan;
    private boolean invalid;
    private boolean care;
    private boolean ethnicKyr;
}
