package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.enrolleeinfo.military.MilitaryResponse;
import university.selectioncommittee.entity.enrolleeinfo.Military;

@Component
public class MilitaryMapper {

    public MilitaryResponse toMilitaryResponse(@NonNull Military military) {
        return MilitaryResponse.builder()
                .id(military.getId())
                .document(military.getDocument())
                .serialNum(military.getSerialNum())
                .nameOfMilitaryRegis(military.getNameOfMilitaryRegis())
                .militaryRegistrationDate(military.getMilitaryRegistrationDate())
                .good(military.isGood())
                .specialAccount(military.isSpecialAccount())
                .specialAccountNumber(military.getSpecialAccountNumber())
                .transferredToTheReserve(military.isTransferredToTheReserve())
                .rank(military.getRank())
                .militaryRegistrationSpecialty(military.getMilitaryRegistrationSpecialty())
                .militaryRegistrationNumber(military.getMilitaryRegistrationNumber())
                .build();
    }
}
