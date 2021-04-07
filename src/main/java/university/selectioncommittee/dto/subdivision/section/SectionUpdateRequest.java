package university.selectioncommittee.dto.subdivision.section;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionUpdateRequest {

    private Long id;
    private String title;
    private String shortTitle;
    private Long directionId;
}
