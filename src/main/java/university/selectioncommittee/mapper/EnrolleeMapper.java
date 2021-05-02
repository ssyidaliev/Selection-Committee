package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.users.enrollee.EnrolleeResponse;
import university.selectioncommittee.entity.users.Enrollee;

@Component
public class EnrolleeMapper {

    public EnrolleeResponse toEnrolleeResponse(@NonNull Enrollee enrollee) {
        return EnrolleeResponse.builder()
                .id(enrollee.getId())
                .firstName(enrollee.getFirstName())
                .lastName(enrollee.getLastName())
                .middleName(enrollee.getMiddleName())
                .dob(enrollee.getDob())
                .email(enrollee.getEmail())
                .phone(enrollee.getPhone())
                .gender(enrollee.getGender())
                .addressLiving(enrollee.getAddressLiving())
                .addressResidence(enrollee.getAddressResidence())
                .addressBirth(enrollee.getAddressBirth())
                .parent(enrollee.getParent())
                .percs(enrollee.getPercs())
                .passport(enrollee.getPassport())
                .military(enrollee.getMilitary())
                .enrollmentDate(enrollee.getEnrollmentDate())
                .education(enrollee.getEducation())
                .entryChallenge(enrollee.getEntryChallenge())
                .build();
    }
}
