package university.selectioncommittee.entity.subdivision;

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
@Table(name = "faculty")
public class Faculty extends TimedEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "short_title")
    private String shortTitle;

    @ManyToOne
    @JoinColumn(name = "vuz_id")
    private VUZ vuz;

}
