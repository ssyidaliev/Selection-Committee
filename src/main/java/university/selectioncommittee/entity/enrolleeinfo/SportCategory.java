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
@Table(name = "sport_category")
public class SportCategory extends TimedEntity {

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "category")
    private String category;

    @NonNull
    @Column(name = "num_doc")
    private String numDoc;
}
