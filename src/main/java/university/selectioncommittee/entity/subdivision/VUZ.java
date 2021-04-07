package university.selectioncommittee.entity.subdivision;

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
@Table(name = "vuz")
public class VUZ extends TimedEntity{

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "short_title")
    private String shortTitle;

    @NotNull
    @Column(name = "address")
    private String address;
}
