package university.selectioncommittee.service.locations;

import university.selectioncommittee.dto.locations.addressliving.AddressLivingCreateRequest;
import university.selectioncommittee.dto.locations.addressliving.AddressLivingUpdateRequest;
import university.selectioncommittee.entity.locations.AddressLiving;

import java.util.List;

public interface AddressLivingService {
    AddressLiving create(AddressLivingCreateRequest request);
    AddressLiving put(Long id, AddressLivingUpdateRequest request);
    AddressLiving retrieve(Long id);
    List<AddressLiving> list();
}
