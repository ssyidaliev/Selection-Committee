package university.selectioncommittee.dto.users.enrollee;

import lombok.Builder;
import lombok.Getter;
import university.selectioncommittee.entity.education.Education;
import university.selectioncommittee.entity.enrolleeinfo.*;
import university.selectioncommittee.entity.locations.AddressBirth;
import university.selectioncommittee.entity.locations.AddressLiving;
import university.selectioncommittee.entity.locations.AddressResidence;
import university.selectioncommittee.entity.users.Parent;
import university.selectioncommittee.enums.GenderType;

import java.time.LocalDate;

@Builder
@Getter
public class EnrolleeResponse{
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate dob;
    private String email;
    private String phone;
    private GenderType gender;
    private AddressLiving addressLiving;
    private AddressResidence addressResidence;
    private AddressBirth addressBirth;
    private Parent parent;
    private Percs percs;
    private Passport passport;
    private Military military;
    private EnrollmentDate enrollmentDate;
    private Education education;
    private EntryChallenge entryChallenge;
}
