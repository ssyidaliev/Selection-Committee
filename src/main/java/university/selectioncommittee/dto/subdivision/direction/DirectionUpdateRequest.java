package university.selectioncommittee.dto.subdivision.direction;

import lombok.Getter;
import lombok.Setter;
import university.selectioncommittee.entity.subdivision.Faculty;

@Getter
@Setter
public class DirectionUpdateRequest {

    private Long id;
    private String cipher;
    private String title;
    private String shortTitle;
    private Faculty faculty;
}
