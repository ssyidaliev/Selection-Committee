package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthResponse;
import university.selectioncommittee.entity.locations.AddressBirth;

@Component
public class AddressBirthMapper {

    public AddressBirthResponse toAddressBirthResponse(@NonNull AddressBirth addressBirth) {
        return AddressBirthResponse.builder()
                .id(addressBirth.getId())
                .republic(addressBirth.getRepublic())
                .region(addressBirth.getRegion())
                .district(addressBirth.getDistrict())
                .city(addressBirth.getCity())
                .village(addressBirth.getVillage())
                .build();
    }
}
