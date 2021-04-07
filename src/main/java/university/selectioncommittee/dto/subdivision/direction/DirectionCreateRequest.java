package university.selectioncommittee.dto.subdivision.direction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DirectionCreateRequest {

    private String cipher;
    private String title;
    private String shortTitle;
    private Long facultyId;
}
