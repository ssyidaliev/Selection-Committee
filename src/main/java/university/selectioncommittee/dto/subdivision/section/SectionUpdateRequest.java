package university.selectioncommittee.dto.subdivision.section;

import lombok.Getter;
import lombok.Setter;
import university.selectioncommittee.entity.subdivision.Direction;

@Getter
@Setter
public class SectionUpdateRequest {

    private Long id;
    private String title;
    private String shortTitle;
    private Direction direction;
}
