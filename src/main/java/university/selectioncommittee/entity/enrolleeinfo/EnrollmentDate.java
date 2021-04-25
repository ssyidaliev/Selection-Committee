package university.selectioncommittee.entity.enrolleeinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import university.selectioncommittee.entity.base.TimedEntity;
import university.selectioncommittee.entity.subdivision.Direction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "enrollment_date")
public class EnrollmentDate extends TimedEntity {

    @NotNull
    @Column(name = "day_form")
    private boolean dayForm;

    @NotNull
    @Column(name = "languages_rus")
    private boolean languagesRus;

    @NotNull
    @Column(name = "study_form")
    private String studyForm;

    @NotNull
    @Column(name = "recommended")
    private boolean recommended;

    @NotNull
    @Column(name = "protocol")
    private String protocol;

    @NotNull
    @Column(name = "recommended_date")
    private LocalDate recommendedDate;

    @NotNull
    @Column(name = "paid")
    private boolean paid;

    @NotNull
    @Column(name = "confirm_enrollment")
    private boolean confirmEnrollment;

    @NotNull
    @Column(name = "confirm_date")
    private LocalDate confirmDate;

    @NotNull
    @Column(name = "enrollment")
    private String enrollment;

    @NotNull
    @Column(name = "order_num")
    private String orderNum;

    @NotNull
    @Column(name = "order_date")
    private LocalDate orderDate;

    @NotNull
    @Column(name = "protocol_num")
    private String protocolNum;

    @NotNull
    @Column(name = "protocol_date")
    private LocalDate protocolDate;

    @NotNull
    @Column(name = "took_docs")
    private boolean tookDocs;

    @NotNull
    @Column(name = "took_docs_date")
    private LocalDate tookDocsDate;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Direction direction;
}
