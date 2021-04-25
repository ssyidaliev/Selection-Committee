package university.selectioncommittee.entity.education;

import lombok.*;
import university.selectioncommittee.entity.base.TimedEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "educational_institution")
public class EducationalInstitution extends TimedEntity {

    @NonNull
    @Column(name = "republic")
    private String republic;

    @NonNull
    @Column(name = "region")
    private String region;

    @NonNull
    @Column(name = "district")
    private String district;

    @NonNull
    @Column(name = "city")
    private String city;

    @NonNull
    @Column(name = "village")
    private String village;

    @ManyToOne
    @JoinColumn(name = "previous_education_id")
    private PreviousEducation previousEducation;
}
