package university.selectioncommittee.dto.subdivision.section;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SectionResponse {

    private Long id;
    private String title;
    private String shortTitle;
    private Long directionId;
}
