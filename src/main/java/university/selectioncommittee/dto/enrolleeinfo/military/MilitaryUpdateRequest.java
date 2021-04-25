package university.selectioncommittee.dto.enrolleeinfo.military;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MilitaryUpdateRequest {
    private Long id;
    private String document;
    private String serialNum;
    private String nameOfMilitaryRegis;
    private LocalDate militaryRegistrationDate;
    private boolean good;
    private boolean specialAccount;
    private String specialAccountNumber;
    private boolean transferredToTheReserve;
    private String rank;
    private String militaryRegistrationSpecialty;
    private String militaryRegistrationNumber;
}
