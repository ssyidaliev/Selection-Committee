package university.selectioncommittee.dto.users.enrollee;

import lombok.Getter;
import lombok.Setter;
import university.selectioncommittee.entity.education.Education;
import university.selectioncommittee.entity.enrolleeinfo.*;
import university.selectioncommittee.entity.locations.AddressBirth;
import university.selectioncommittee.entity.locations.AddressLiving;
import university.selectioncommittee.entity.locations.AddressResidence;
import university.selectioncommittee.entity.users.Parent;
import university.selectioncommittee.enums.GenderType;

import java.time.LocalDate;

@Getter
@Setter
public class EnrolleeUpdateRequest {

    private Long id;
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
