package university.selectioncommittee.dto.subdivision.faculty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FacultyResponse {

    private Long id;
    private String title;
    private String shortTitle;
    private Long vuzId;
}
