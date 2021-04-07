package university.selectioncommittee.mapper;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import university.selectioncommittee.dto.locations.addressliving.AddressLivingResponse;
import university.selectioncommittee.entity.locations.AddressLiving;

@Component
public class AddressLivingMapper {

    public AddressLivingResponse toAddressLivingResponse(@NonNull AddressLiving addressLiving) {
        return AddressLivingResponse.builder()
                .id(addressLiving.getId())
                .republic(addressLiving.getRepublic())
                .region(addressLiving.getRegion())
                .district(addressLiving.getDistrict())
                .city(addressLiving.getCity())
                .village(addressLiving.getVillage())
                .phone(addressLiving.getPhone())
                .build();
    }
}
