package university.selectioncommittee.dto.subdivision.direction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DirectionUpdateRequest {

    private Long id;
    private String cipher;
    private String title;
    private String shortTitle;
    private Long facultyId;
}
