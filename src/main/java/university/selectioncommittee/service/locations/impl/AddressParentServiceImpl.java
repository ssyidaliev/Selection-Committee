package university.selectioncommittee.service.locations.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.selectioncommittee.dto.locations.addressparent.AddressParentCreateRequest;
import university.selectioncommittee.dto.locations.addressparent.AddressParentUpdateRequest;
import university.selectioncommittee.entity.locations.AddressParent;
import university.selectioncommittee.exception.ResourceNotFoundException;
import university.selectioncommittee.repository.locations.AddressParentRepository;
import university.selectioncommittee.service.locations.AddressParentService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressParentServiceImpl implements AddressParentService {

    private final AddressParentRepository addressParentRepository;

    public AddressParentServiceImpl(AddressParentRepository addressParentRepository) {
        this.addressParentRepository = addressParentRepository;
    }

    @Override
    @Transactional
    public AddressParent create(@NonNull AddressParentCreateRequest request) {
        AddressParent addressParent = new AddressParent();
        addressParent.setRepublic(request.getRepublic());
        addressParent.setRegion(request.getRegion());
        addressParent.setDistrict(request.getDistrict());
        addressParent.setCity(request.getCity());
        addressParent.setVillage(request.getVillage());
        addressParent.setCreateAt(LocalDateTime.now());
        return addressParentRepository.save(addressParent);
    }

    @Override
    @Transactional
    public AddressParent put(@NonNull Long id, @NonNull AddressParentUpdateRequest request) {
        AddressParent addressParent = retrieve(id);
        addressParent.setRepublic(request.getRepublic());
        addressParent.setRegion(request.getRegion());
        addressParent.setDistrict(request.getDistrict());
        addressParent.setCity(request.getCity());
        addressParent.setVillage(request.getVillage());
        addressParent.setUpdateAt(LocalDateTime.now());
        return addressParentRepository.save(addressParent);
    }

    @Override
    @Transactional(readOnly = true)
    public AddressParent retrieve(@NonNull Long id) {
        return addressParentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Address Parent with id " + id + " does not exist"
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressParent> list() {
        return addressParentRepository.findAll();
    }
}
