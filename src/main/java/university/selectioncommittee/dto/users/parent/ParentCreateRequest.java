package university.selectioncommittee.dto.users.parent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentCreateRequest {

    private String firstName;
    private String lastName;
    private String middleName;
    private String job;
    private String position;
    private String email;
    private String phone;
    private Long addressParentId;
}
