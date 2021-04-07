package university.selectioncommittee.dto.users.parent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentUpdateRequest {

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
