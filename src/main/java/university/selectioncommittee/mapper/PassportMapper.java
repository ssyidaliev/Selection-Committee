package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.enrolleeinfo.passport.PassportResponse;
import university.selectioncommittee.entity.enrolleeinfo.Passport;

@Component
public class PassportMapper {

    public PassportResponse toPassportResponse(@NonNull Passport passport) {
        return PassportResponse.builder()
                .id(passport.getId())
                .serialNum(passport.getSerialNum())
                .married(passport.getMarried())
                .citizenship(passport.getCitizenship())
                .issuingAuth(passport.getIssuingAuth())
                .getDateAuth(passport.getGetDateAuth())
                .build();
    }
}
