package university.selectioncommittee.dto.users.parent;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParentResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String job;
    private String position;
    private String email;
    private String phone;
    private Long addressParentId;
}
