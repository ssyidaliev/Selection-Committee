package university.selectioncommittee.dto.education.previouseducation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PreviousEducationResponse {

    private Long id;
    public String name;
    public String type;
}
