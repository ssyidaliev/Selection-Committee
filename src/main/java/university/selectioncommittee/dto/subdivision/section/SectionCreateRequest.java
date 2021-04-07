package university.selectioncommittee.dto.subdivision.section;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionCreateRequest {

    private String title;
    private String shortTitle;
    private Long directionId;
}
