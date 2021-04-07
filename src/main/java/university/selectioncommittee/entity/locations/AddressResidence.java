package university.selectioncommittee.entity.locations;

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
@Table(name = "address_residence")
public class AddressResidence extends TimedEntity {

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

    @NonNull
    @Column(name = "phone")
    private String phone;
}
