package university.selectioncommittee.dto.enrolleeinfo.passport;

import lombok.Getter;
import lombok.Setter;
import university.selectioncommittee.enums.MarriedType;

import java.time.LocalDate;

@Getter
@Setter
public class PassportUpdateRequest {

    private Long id;
    private String serialNum;
    private MarriedType married;
    private String citizenship;
    private String issuingAuth;
    private LocalDate getDateAuth;
}
