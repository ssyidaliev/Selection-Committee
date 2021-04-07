package university.selectioncommittee.service.locations.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.locations.addressliving.AddressLivingCreateRequest;
import university.selectioncommittee.dto.locations.addressliving.AddressLivingUpdateRequest;
import university.selectioncommittee.entity.locations.AddressLiving;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.locations.AddressLivingRepository;
import university.selectioncommittee.service.locations.AddressLivingService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressLivingServiceImpl implements AddressLivingService {

    private final AddressLivingRepository addressLivingRepository;

    public AddressLivingServiceImpl(AddressLivingRepository addressLivingRepository) {
        this.addressLivingRepository = addressLivingRepository;
    }

    @Override
    @Transactional
    public AddressLiving create(@NonNull AddressLivingCreateRequest request) {
        AddressLiving addressLiving = new AddressLiving();
        addressLiving.setRepublic(request.getRepublic());
        addressLiving.setRegion(request.getRegion());
        addressLiving.setDistrict(request.getDistrict());
        addressLiving.setCity(request.getCity());
        addressLiving.setVillage(request.getVillage());
        addressLiving.setPhone(request.getPhone());
        addressLiving.setCreateAt(LocalDateTime.now());
        return addressLivingRepository.save(addressLiving);
    }

    @Override
    @Transactional
    public AddressLiving put(@NonNull Long id, @NonNull AddressLivingUpdateRequest request) {
        AddressLiving addressLiving = retrieve(id);
        addressLiving.setRepublic(request.getRepublic());
        addressLiving.setRegion(request.getRegion());
        addressLiving.setDistrict(request.getDistrict());
        addressLiving.setCity(request.getCity());
        addressLiving.setVillage(request.getVillage());
        addressLiving.setPhone(request.getPhone());
        addressLiving.setUpdateAt(LocalDateTime.now());
        return addressLivingRepository.save(addressLiving);
    }

    @Override
    @Transactional(readOnly = true)
    public AddressLiving retrieve(@NonNull Long id) {
        return addressLivingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Address Living with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressLiving> list() {
        return addressLivingRepository.findAll();
    }
}
