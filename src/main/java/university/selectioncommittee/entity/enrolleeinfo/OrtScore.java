package university.selectioncommittee.entity.enrolleeinfo;

import lombok.*;
import university.selectioncommittee.entity.base.TimedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ort_score")
public class OrtScore extends TimedEntity {

    @NonNull
    @Column(name = "basic_score")
    private Integer basicScore;

    @NonNull
    @Column(name = "kyr_sub_score")
    private Integer kyrSubScore;

    @NonNull
    @Column(name = "bio_sub_score")
    private Integer bioSubScore;

    @NonNull
    @Column(name = "phy_sub_score")
    private Integer phySubScore;

    @NonNull
    @Column(name = "chem_sub_score")
    private Integer chemSubScore;

    @NonNull
    @Column(name = "math_sub_score")
    private Integer mathSubScore;

    @NonNull
    @Column(name = "his_sub_score")
    private Integer hisSubScore;

    @NonNull
    @Column(name = "eng_sub_score")
    private Integer engSubScore;

    @NonNull
    @Column(name = "rus_sub_score")
    private Integer rusSubScore;
}
