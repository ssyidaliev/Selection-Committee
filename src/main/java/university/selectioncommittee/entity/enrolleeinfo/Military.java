package university.selectioncommittee.entity.enrolleeinfo;

import lombok.*;
import university.selectioncommittee.entity.base.TimedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "military")
public class Military extends TimedEntity {

    @NonNull
    @Column(name = "document")
    private String document;

    @NonNull
    @Column(name = "serial_num")
    private String serialNum;

    @NonNull
    @Column(name = "name_of_military_regis")
    private String nameOfMilitaryRegis;

    @NonNull
    @Column(name = "military_registration_date")
    private LocalDate militaryRegistrationDate;

    @NonNull
    @Column(name = "good")
    private boolean good;

    @NonNull
    @Column(name = "special_account")
    private boolean specialAccount;

    @NonNull
    @Column(name = "special_account_number")
    private String specialAccountNumber;

    @NonNull
    @Column(name = "transferred_to_the_reserve")
    private boolean transferredToTheReserve;

    @NonNull
    @Column(name = "rank")
    private String rank;

    @NonNull
    @Column(name = "military_registration_specialty")
    private String militaryRegistrationSpecialty;

    @NonNull
    @Column(name = "military_registration_number")
    private String militaryRegistrationNumber;

}
