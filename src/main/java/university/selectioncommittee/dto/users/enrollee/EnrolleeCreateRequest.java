package university.selectioncommittee.dto.users.enrollee;

import lombok.Getter;
import lombok.Setter;
import university.selectioncommittee.enums.GenderType;

import java.time.LocalDate;

@Getter
@Setter
public class EnrolleeCreateRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate dob;
    private String email;
    private String phone;
    private GenderType gender;
    private Long addressLivingId;
    private Long addressResidenceId;
    private Long addressBirthId;
    private Long parentId;
    private Long percsId;
    private Long passportId;
    private Long militaryId;
    private Long enrollmentDateId;
    private Long educationId;
    private Long entryChallengeId;
}
