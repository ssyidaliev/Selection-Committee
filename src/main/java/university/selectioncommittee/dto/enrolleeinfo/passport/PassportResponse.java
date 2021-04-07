package university.selectioncommittee.dto.enrolleeinfo.passport;

import lombok.Builder;
import lombok.Getter;
import university.selectioncommittee.enums.MarriedType;

import java.time.LocalDate;

@Getter
@Builder
public class PassportResponse {

    private Long id;
    private String serialNum;
    private MarriedType married;
    private String citizenship;
    private String issuingAuth;
    private LocalDate getDateAuth;
}
