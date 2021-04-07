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
@Table(name = "percs")
public class Percs extends TimedEntity {

    @NotNull
    @Column(name = "orphan")
    private boolean orphan;

    @NotNull
    @Column(name = "invalid")
    private boolean invalid;

    @NotNull
    @Column(name = "care")
    private boolean care;

    @NotNull
    @Column(name = "ethnic_kyr")
    private boolean ethnicKyr;

}
