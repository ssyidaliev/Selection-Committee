package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.education.education.EducationResponse;
import university.selectioncommittee.entity.education.Education;

@Component
public class EducationMapper {

    public EducationResponse toEducationResponse(@NonNull Education education) {
        return EducationResponse.builder()
                .id(education.getId())
                .originalDiplomaOrCertificate(education.isOriginalDiplomaOrCertificate())
                .excellentStudent(education.isExcellentStudent())
                .goldMedal(education.isGoldMedal())
                .prizeWinner(education.isPrizeWinner())
                .DiplomaOrCertificate(education.isDiplomaOrCertificate())
                .serialDiplomaOrCertificate(education.getSerialDiplomaOrCertificate())
                .numDiplomaOrCertificate(education.getNumDiplomaOrCertificate())
                .yearOfIssue(education.getYearOfIssue())
                .schoolLanguage(education.getSchoolLanguage())
                .foreignLanguage(education.getForeignLanguage())
                .outOfCompetition(education.isDiplomaOrCertificate())
                .sportCategory(education.getSportCategory())
                .kstuStudent(education.isKstuStudent())
                .educationalInstitution(education.getEducationalInstitution())
                .build();
    }
}
