package university.selectioncommittee.service.locations.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthCreateRequest;
import university.selectioncommittee.dto.locations.addressbirth.AddressBirthUpdateRequest;
import university.selectioncommittee.entity.locations.AddressBirth;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.locations.AddressBirthRepository;
import university.selectioncommittee.service.locations.AddressBirthService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressBirthServiceImpl implements AddressBirthService {

    private final AddressBirthRepository addressBirthRepository;

    public AddressBirthServiceImpl(AddressBirthRepository addressBirthRepository) {
        this.addressBirthRepository = addressBirthRepository;
    }

    @Override
    @Transactional
    public AddressBirth create(@NonNull AddressBirthCreateRequest request) {
        AddressBirth addressBirth = new AddressBirth();
        addressBirth.setRepublic(request.getRepublic());
        addressBirth.setRegion(request.getRegion());
        addressBirth.setDistrict(request.getDistrict());
        addressBirth.setCity(request.getCity());
        addressBirth.setVillage(request.getVillage());
        addressBirth.setCreateAt(LocalDateTime.now());
        return addressBirthRepository.save(addressBirth);
    }

    @Override
    @Transactional
    public AddressBirth put(@NonNull Long id, @NonNull AddressBirthUpdateRequest request) {
        AddressBirth addressBirth = retrieve(id);
        addressBirth.setRepublic(request.getRepublic());
        addressBirth.setRegion(request.getRegion());
        addressBirth.setDistrict(request.getDistrict());
        addressBirth.setCity(request.getCity());
        addressBirth.setVillage(request.getVillage());
        addressBirth.setUpdateAt(LocalDateTime.now());
        return addressBirthRepository.save(addressBirth);
    }

    @Override
    @Transactional(readOnly = true)
    public AddressBirth retrieve(@NonNull Long id) {
        return addressBirthRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Address Birth with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressBirth> list() {
        return addressBirthRepository.findAll();
    }
}
