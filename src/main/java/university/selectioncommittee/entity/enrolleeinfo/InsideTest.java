package university.selectioncommittee.entity.enrolleeinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import university.selectioncommittee.entity.base.TimedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "inside_test")
public class InsideTest extends TimedEntity {

    @NotNull
    @Column(name = "passed_by_ort_result")
    private boolean passedByOrtResult;

    @NotNull
    @Column(name = "req_score")
    private Integer reqScore;

    @NotNull
    @Column(name = "place_num")
    private Integer placeNum;

    @NotNull
    @Column(name = "place_count")
    private Integer placeCount;
}
