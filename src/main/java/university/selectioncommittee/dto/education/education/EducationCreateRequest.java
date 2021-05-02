package university.selectioncommittee.dto.education.education;

import lombok.Getter;
import lombok.Setter;
import university.selectioncommittee.entity.education.EducationalInstitution;
import university.selectioncommittee.entity.enrolleeinfo.SportCategory;

import java.time.LocalDate;

@Getter
@Setter
public class EducationCreateRequest {
    private boolean originalDiplomaOrCertificate;
    private boolean excellentStudent;
    private boolean goldMedal;
    private boolean prizeWinner;
    private boolean DiplomaOrCertificate;
    private String serialDiplomaOrCertificate;
    private String numDiplomaOrCertificate;
    private LocalDate yearOfIssue;
    private String schoolLanguage;
    private String foreignLanguage;
    private boolean outOfCompetition;
    private Long sportCategoryId;
    private boolean kstuStudent;
    private Long educationalInstitutionId;
}
