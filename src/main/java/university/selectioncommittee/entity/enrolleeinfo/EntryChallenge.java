package university.selectioncommittee.entity.enrolleeinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import university.selectioncommittee.entity.base.TimedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "entry_challenge")
public class EntryChallenge extends TimedEntity {

    @NotNull
    @Column(name = "passed_ort")
    private boolean passedOrt;

    @Column(name = "certificate_num")
    private String certificateNum;

    @Column(name = "certificate_color")
    private String certificateColor;

    @Column(name = "sum_score")
    private String sumScore;

    @NotNull
    @Column(name = "tour_num")
    private String tourNum;

    @NotNull
    @Column(name = "after_collage")
    private boolean afterCollage;

    @NotNull
    @Column(name = "dont_appear")
    private boolean dontAppear;

    @NotNull
    @Column(name = "no_satisfied")
    private boolean noSatisfied;

    @NotNull
    @Column(name = "passed_inside_test")
    private boolean passedInsideTest;

    @ManyToOne
    @JoinColumn(name = "inside_test")
    private InsideTest insideTest;

    @ManyToOne
    @JoinColumn(name = "ort_score_id")
    private OrtScore ortScore;
}
