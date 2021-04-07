package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceResponse;
import university.selectioncommittee.entity.locations.AddressResidence;

@Component
public class AddressResidenceMapper {

    public AddressResidenceResponse toAddressResidenceResponse(@NonNull AddressResidence addressResidence) {
        return AddressResidenceResponse.builder()
                .id(addressResidence.getId())
                .republic(addressResidence.getRepublic())
                .region(addressResidence.getRegion())
                .district(addressResidence.getDistrict())
                .city(addressResidence.getCity())
                .village(addressResidence.getVillage())
                .build();
    }
}
