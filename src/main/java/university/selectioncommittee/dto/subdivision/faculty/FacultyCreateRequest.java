package university.selectioncommittee.dto.subdivision.faculty;

import lombok.Getter;
import lombok.Setter;
import university.selectioncommittee.entity.subdivision.VUZ;

@Getter
@Setter
public class FacultyCreateRequest {

    private String title;
    private String shortTitle;
    private VUZ vuz;
}
