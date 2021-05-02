package university.selectioncommittee.entity.education;

import lombok.*;
import university.selectioncommittee.entity.base.TimedEntity;
import university.selectioncommittee.entity.enrolleeinfo.SportCategory;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "education")
public class Education extends TimedEntity {

    @NonNull
    @Column(name = "original_diploma_or_certificate")
    private boolean originalDiplomaOrCertificate;

    @NonNull
    @Column(name = "excellent_student")
    private boolean excellentStudent;

    @NonNull
    @Column(name = "gold_medal")
    private boolean goldMedal;

    @NonNull
    @Column(name = "prize_winner")
    private boolean prizeWinner;

    @NonNull
    @Column(name = "diploma_or_certificate")
    private boolean DiplomaOrCertificate;

    @Column(name = "serial_diploma_or_certificate")
    private String serialDiplomaOrCertificate;

    @Column(name = "num_diploma_or_certificate")
    private String numDiplomaOrCertificate;

    @Column(name = "year_of_issue")
    private LocalDate yearOfIssue;

    @NonNull
    @Column(name = "school_language")
    private String schoolLanguage;

    @NonNull
    @Column(name = "foreign_language")
    private String foreignLanguage;

    @NonNull
    @Column(name = "out_of_competition")
    private boolean outOfCompetition;

    @ManyToOne
    @JoinColumn(name = "sport_category_id")
    private SportCategory sportCategory;

    @NonNull
    @Column(name = "kstu_student")
    private boolean kstuStudent;

    @ManyToOne
    @JoinColumn(name = "educational_institution_id")
    private EducationalInstitution educationalInstitution;

}
