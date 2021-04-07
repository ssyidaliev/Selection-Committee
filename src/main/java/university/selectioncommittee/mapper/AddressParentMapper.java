package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.locations.addressparent.AddressParentResponse;
import university.selectioncommittee.entity.locations.AddressParent;

@Component
public class AddressParentMapper {

    public AddressParentResponse toAddressParentResponse(@NonNull AddressParent addressParent) {
        return AddressParentResponse.builder()
                .id(addressParent.getId())
                .republic(addressParent.getRepublic())
                .region(addressParent.getRegion())
                .district(addressParent.getDistrict())
                .city(addressParent.getCity())
                .village(addressParent.getVillage())
                .build();
    }
}
