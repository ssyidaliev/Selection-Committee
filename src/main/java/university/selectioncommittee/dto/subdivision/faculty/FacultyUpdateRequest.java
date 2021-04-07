package university.selectioncommittee.dto.subdivision.faculty;

import lombok.Getter;
import lombok.Setter;
import university.selectioncommittee.entity.subdivision.VUZ;

@Getter
@Setter
public class FacultyUpdateRequest {

    private Long id;
    private String title;
    private String shortTitle;
    private Long vuzId;
}
