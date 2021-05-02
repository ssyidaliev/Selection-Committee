package university.selectioncommittee.dto.education.education;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import university.selectioncommittee.entity.education.EducationalInstitution;
import university.selectioncommittee.entity.enrolleeinfo.SportCategory;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Builder
public class EducationResponse {

    private Long id;
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
    private SportCategory sportCategory;
    private boolean kstuStudent;
    private EducationalInstitution educationalInstitution;
}
