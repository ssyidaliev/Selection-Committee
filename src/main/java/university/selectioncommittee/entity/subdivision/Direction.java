package university.selectioncommittee.entity.subdivision;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import university.selectioncommittee.entity.base.TimedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "direction")
public class Direction extends TimedEntity {

    @Column(name = "cipher", nullable = false)
    private String cipher;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "short_title", nullable = false)
    private String shortTitle;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

}
