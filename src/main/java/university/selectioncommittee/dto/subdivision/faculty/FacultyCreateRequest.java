package university.selectioncommittee.dto.subdivision.faculty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacultyCreateRequest {

    private String title;
    private String shortTitle;
    private Long vuzId;
}
