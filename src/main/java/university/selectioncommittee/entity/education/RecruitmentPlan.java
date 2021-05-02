package university.selectioncommittee.entity.education;

import lombok.*;
import university.selectioncommittee.entity.base.TimedEntity;
import university.selectioncommittee.entity.subdivision.Direction;
import university.selectioncommittee.entity.subdivision.Faculty;
import university.selectioncommittee.entity.subdivision.Section;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "recruitment_plan")
public class RecruitmentPlan extends TimedEntity {

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Direction direction;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @NonNull
    @Column(name = "study_form")
    private String studyForm;

    @NonNull
    @Column(name = "doc_money")
    private Integer docMoney;

    @NonNull
    @Column(name = "study_money")
    private Integer studyMoney;

    @NonNull
    @Column(name = "pay_type")
    private String payType;

    @NonNull
    @Column(name = "req_test")
    private boolean reqTest;
}
