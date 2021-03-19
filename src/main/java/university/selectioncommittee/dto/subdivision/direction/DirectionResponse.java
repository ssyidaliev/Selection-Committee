package university.selectioncommittee.dto.subdivision.direction;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DirectionResponse {

    private Long id;
    private String cipher;
    private String title;
    private String shortTitle;
    private Long facultyId;
}
