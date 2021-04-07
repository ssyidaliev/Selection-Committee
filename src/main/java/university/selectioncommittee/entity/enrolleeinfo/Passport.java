package university.selectioncommittee.entity.enrolleeinfo;

import lombok.*;
import university.selectioncommittee.entity.base.TimedEntity;
import university.selectioncommittee.enums.MarriedType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "passport")
public class Passport extends TimedEntity {

    @NonNull
    @Column(name = "serial_num")
    private String serialNum;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "married")
    private MarriedType married;

    @NonNull
    @Column(name = "citizenship")
    private String citizenship;

    @NonNull
    @Column(name = "issuing_auth")
    private String issuingAuth;

    @NotNull
    @Column(name = "get_date_auth")
    private LocalDate getDateAuth;
}
