package university.selectioncommittee.dto.education.previouseducation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreviousEducationUpdateRequest {

    private Long id;
    public String name;
    public String type;
}
