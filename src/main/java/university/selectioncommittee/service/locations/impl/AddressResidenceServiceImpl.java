package university.selectioncommittee.service.locations.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceCreateRequest;
import university.selectioncommittee.dto.locations.addressresidence.AddressResidenceUpdateRequest;
import university.selectioncommittee.entity.locations.AddressResidence;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.locations.AddressResidenceRepository;
import university.selectioncommittee.service.locations.AddressResidenceService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressResidenceServiceImpl implements AddressResidenceService {

    private final AddressResidenceRepository addressResidenceRepository;

    public AddressResidenceServiceImpl(AddressResidenceRepository addressResidenceRepository) {
        this.addressResidenceRepository = addressResidenceRepository;
    }

    @Override
    @Transactional
    public AddressResidence create(@NonNull AddressResidenceCreateRequest request) {
        AddressResidence addressResidence = new AddressResidence();
        addressResidence.setRepublic(request.getRepublic());
        addressResidence.setRegion(request.getRegion());
        addressResidence.setDistrict(request.getDistrict());
        addressResidence.setCity(request.getCity());
        addressResidence.setVillage(request.getVillage());
        addressResidence.setCreateAt(LocalDateTime.now());
        return addressResidenceRepository.save(addressResidence);
    }

    @Override
    @Transactional
    public AddressResidence put(@NonNull Long id, @NonNull AddressResidenceUpdateRequest request) {
        AddressResidence addressResidence = retrieve(id);
        addressResidence.setRepublic(request.getRepublic());
        addressResidence.setRegion(request.getRegion());
        addressResidence.setDistrict(request.getDistrict());
        addressResidence.setCity(request.getCity());
        addressResidence.setVillage(request.getVillage());
        addressResidence.setUpdateAt(LocalDateTime.now());
        return addressResidenceRepository.save(addressResidence);
    }

    @Override
    @Transactional(readOnly = true)
    public AddressResidence retrieve(@NonNull Long id) {
        return addressResidenceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Address Residence with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressResidence> list() {
        return addressResidenceRepository.findAll();
    }
}
